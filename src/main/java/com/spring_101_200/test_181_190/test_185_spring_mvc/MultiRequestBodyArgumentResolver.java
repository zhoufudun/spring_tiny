package com.spring_101_200.test_181_190.test_185_spring_mvc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.utils.StringUtils;
import lz.mysql.MysqlUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * MultiRequestBody解析器
 * 解决的问题：
 * 1、单个字符串等包装类型都要写一个对象才可以用@RequestBody接收；
 * 2、多个对象需要封装到一个对象里才可以用@RequestBody接收。
 * 主要优势：
 * 1、支持通过注解的value指定JSON的key来解析对象。
 * 2、支持通过注解无value，直接根据参数名来解析对象
 * 3、支持基本类型的注入
 * 4、支持GET和其他请求方式注入
 * 5、支持通过注解无value且参数名不匹配JSON串key时，根据属性解析对象。
 * 6、支持多余属性(不解析、不报错)、支持参数“共用”（不指定value时，参数名不为JSON串的key）
 * 7、支持当value和属性名找不到匹配的key时，对象是否匹配所有属性。
 *
 * @author Wangyang Liu  QQ: 605283073
 * @date 2018/08/27
 */
public class MultiRequestBodyArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String JSONBODY_ATTRIBUTE = "JSON_REQUEST_BODY";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 设置支持的方法参数类型
     *
     * @param parameter 方法参数
     * @return 支持的类型
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 支持带@MultiRequestBody注解的参数
        return parameter.hasParameterAnnotation(MultiRequestBody.class);
    }

    /**
     * 参数解析，利用fastjson
     * 注意：非基本类型返回null会报空指针异常，要通过反射或者JSON工具类创建一个空对象
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String jsonBody = getRequestBody(webRequest);
        Class<?> parameterType = parameter.getParameterType();

        JSONObject jsonObject = JSON.parseObject(jsonBody);
        // 根据@MultiRequestBody注解value作为json解析的key
        MultiRequestBody parameterAnnotation = parameter.getParameterAnnotation(MultiRequestBody.class);
        //注解的value是JSON的key
        String key = parameterAnnotation.value();
        Object value = null;
        // 注解为设置value则用参数名当做json的key
        key = parameter.getParameterName();
        value = jsonObject.get(key);
        // 将 order_no 转化为 orderNo, 再次获取数据
        if (value == null) {
            String k = MysqlUtil.field2JavaCode(key);
            value = jsonObject.get(k);
        }
        // 通过注解的value或者参数名解析，能拿到value进行解析
        if (value != null) {
            //基本类型,int ,double
            if (parameterType.isPrimitive()) {
                System.out.println("这里对于基本数据类型的处理，有兴趣的同学自己封装");
                return null;
            }
            // 基本类型包装类 Integer ，Double 等
            if (parameterType == Integer.class
                    || parameterType == Character.class) {
                System.out.println("这里对于基类类型的包类型处理，有兴趣的同学自己封装");
                return null;
                // 字符串类型
            } else if (parameterType == String.class) {
                return value.toString();
            }
            // 其他复杂对象
            return JSON.parseObject(value.toString(), parameterType);
        }
        return value;
    }

    private String getRequestBody(NativeWebRequest webRequest) {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        // 有就直接获取
        String jsonBody = (String) webRequest.getAttribute(JSONBODY_ATTRIBUTE, NativeWebRequest.SCOPE_REQUEST);
        // 没有就从请求中读取
        if (jsonBody == null) {
            try {
                jsonBody = IOUtils.toString(servletRequest.getReader());
                webRequest.setAttribute(JSONBODY_ATTRIBUTE, jsonBody, NativeWebRequest.SCOPE_REQUEST);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (StringUtils.isBlank(jsonBody)) {
            Map<String, String[]> readOnlyMap = servletRequest.getParameterMap();
            Map writeAbleMap = new HashMap();
            for (Map.Entry<String, String[]> entry : readOnlyMap.entrySet()) {
                String key = entry.getKey();
                String value = "";
                if (entry.getValue() != null) {
                    if (entry.getValue().length == 1) {
                        value = entry.getValue()[0];
                    } else {
                        for (String v : entry.getValue()) {
                            value = value + "," + v;
                        }
                    }
                }
                writeAbleMap.put(key, value);
            }
            jsonBody = JSON.toJSONString(writeAbleMap);
        }
        return jsonBody;
    }
}
