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

package com.spring_101_200.test_151_160.test_154_mybatis_plugins;

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
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class QueryInterceptor extends SqlParserHandler implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) PluginUtils.realTarget(invocation.getTarget());
        MetaObject metaStmtHandler = SystemMetaObject.forObject(statementHandler);
        //分离代理对象，从而形成多次代理，通过两次循环最原始的被代理的类，MyBatis使用的是JDK代理
        while (metaStmtHandler.hasGetter("h")){
            Object object = metaStmtHandler.getValue("h");
            metaStmtHandler = SystemMetaObject.forObject(object);
        }
        //分离最后一个代理对象的目标类
        while (metaStmtHandler.hasGetter("target")){
            Object object = metaStmtHandler.getValue("target");
            metaStmtHandler = SystemMetaObject.forObject(object);
        }
        //取出即将要执行的SQL
        String originalSql = (String)metaStmtHandler.getValue("delegate.boundSql.sql");
        //这只是一个简单的处理，现实情况要复杂得多
        if(!originalSql.contains("is_delete") && !originalSql.contains(" left ") && !originalSql.contains(" inner ")){
            originalSql = originalSql + " and is_delete  = 0 ";
        }
        System.out.println("=========>>>>>>>>>>>>> " + originalSql);
        //重写要执行的SQL
        metaStmtHandler.setValue("delegate.boundSql.sql",originalSql);
        //调用原来的对象方法，进行责任链的下一层级
        return invocation.proceed();
    }


    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            //使用默认的MyBatis提供类生成代理对象
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
