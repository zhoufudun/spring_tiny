package com.spring_101_200.test_141_150.test_141_mybatis_usegeneratedkeys_keyproperty;

import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.builder.ParameterExpression;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.xmltags.DynamicContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Test141_test_getterType {

    public static final String PARAMETER_OBJECT_KEY = "_parameter";
    public static final String DATABASE_ID_KEY = "_databaseId";

    public static void main(String[] args) {
        ContextMap bindings = null;
        User user  = new User();
        if (user != null && !(user instanceof Map)) {
            MetaObject metaObject = MetaObject.forObject(user, new DefaultObjectFactory(), new DefaultObjectWrapperFactory());
            bindings = new ContextMap(metaObject);
        }
        bindings.put(PARAMETER_OBJECT_KEY, user);
        bindings.put(DATABASE_ID_KEY, "mysql");

        Map<String,String> parameterMap = parseParameterMapping("_parameter.username");
        String property = parameterMap.get("property");
        System.out.println("=========property=======" + property);

        MetaObject metaObject =  MetaObject.forObject(bindings, new DefaultObjectFactory(), new DefaultObjectWrapperFactory());
        Class<?> clazz = metaObject.getGetterType(property);
        System.out.println(clazz);
    }

    public static Map<String, String> parseParameterMapping(String content) {
        try {
            return new ParameterExpression(content);
        } catch (BuilderException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new BuilderException("Parsing error was found in mapping #{" + content + "}.  Check syntax #{property|(expression), var1=value1, var2=value2, ...} ", ex);
        }
    }

    static class ContextMap extends HashMap<String, Object> {
        private static final long serialVersionUID = 2977601501966151582L;

        private MetaObject parameterMetaObject;
        public ContextMap(MetaObject parameterMetaObject) {
            this.parameterMetaObject = parameterMetaObject;
        }

        @Override
        public Object put(String key, Object value) {
            return super.put(key, value);
        }

        @Override
        public Object get(Object key) {
            String strKey = (String) key;
            if (super.containsKey(strKey)) {
                return super.get(strKey);
            }

            if (parameterMetaObject != null) {
                Object object = parameterMetaObject.getValue(strKey);
                // issue #61 do not modify the context when reading
//        if (object != null) {
//          super.put(strKey, object);
//        }

                return object;
            }

            return null;
        }
    }
}
