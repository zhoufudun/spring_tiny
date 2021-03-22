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

import com.baomidou.mybatisplus.plugins.SqlParserHandler;
import com.baomidou.mybatisplus.toolkit.PluginUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author songfayuan
 * @date 2018/1/19
 * 数据权限插件，guns
 */
@Slf4j
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class NewDataScopeInterceptor extends SqlParserHandler implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) PluginUtils.realTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        //进行绑定
        //分离代理对象链（由于目标类可能被多个拦截器拦截，从而形成多次代理，通过循环可以分离出最原始的目标类）
        while(metaObject.hasGetter("h")){
            Object object = metaObject.getValue("h");
            metaObject =  SystemMetaObject.forObject(object);
        }
        //BoundSql对象是处理SQL语句用的
        String  sql = (String)metaObject.getValue("delegate.boundSql.sql");
        //判断SQL是否是select语句，如果不是select语句，那么就出错
        //如果是，则修改它，最多返回1000行，这里用的是MySQL数据库，其他数据库要改写成其他的
        if(sql != null && sql.toUpperCase().trim().indexOf("select") == 0 ){
            //通过SQL重写来实现，这里我们起了一个奇怪的别名，避免与表名重复
            sql = "select * from ("  + sql + " ) $_$limit_$table_limit 1000";
            metaObject.setValue("delegate.boundSql.sql",sql);
        }
        Object result = invocation.proceed();
        return result;
    }


    /**
     * 生成拦截对象的代理
     *
     * @param target 目标对象
     * @return 代理对象
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    /**
     * @param properties mybatis配置的属性
     */
    @Override
    public void setProperties(Properties properties) {

    }


}
