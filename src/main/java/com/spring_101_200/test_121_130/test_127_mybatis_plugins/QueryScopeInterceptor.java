/*
 *    Copyright (c) 2018-2025, songfayuan All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the 霖梓控股 developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: songfayuan (1414798079@qq.com)
 */

package com.spring_101_200.test_121_130.test_127_mybatis_plugins;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author songfayuan
 * @date 2018/1/19
 * 数据权限插件，guns
 */
@Slf4j
@Intercepts({@Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class QueryScopeInterceptor implements Interceptor {

    /**
     * 代替拦截对象的方法内容
     * 责任链对象
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        DefaultResultSetHandler defaultResultSetHandler = (DefaultResultSetHandler) invocation.getTarget();
        //MappedStatement维护了一条<select|update|delete|insert>节点的封装
        MetaObject metaObject = SystemMetaObject.forObject(defaultResultSetHandler);
        // 先判断是不是SELECT操作
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("mappedStatement");
        //获取节点属性的集合
        List<ResultMap> resultMaps = mappedStatement.getResultMaps();
        int resultMapCount = resultMaps.size();
        //获取当前resutType的类型
        Class<?> resultType = resultMaps.get(0).getType();
        System.out.println(resultType);
        Object list = invocation.proceed();
        System.out.println(JSON.toJSONString(list));
        return list;
    }

    /**
     * 生成拦截对象的代理
     *
     * @param target 目标对象
     * @return 代理对象
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof ResultSetHandler) {
            //使用MyBatis提供的Plugin类生成代理对象
            return Plugin.wrap(target, this);
        }
        return target;
    }

    /**
     * @param properties mybatis获取插件的属性，我们在MyBatis配置文件里配置的
     */
    @Override
    public void setProperties(Properties properties) {

    }


}
