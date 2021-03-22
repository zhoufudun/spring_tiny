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
public class DataScopeInterceptor extends SqlParserHandler implements Interceptor {


    /**
     * 代替拦截对象的方法内容
     * 责任链对象
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) PluginUtils.realTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        this.sqlParser(metaObject);
        // 先判断是不是SELECT操作
        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        String originalSql = boundSql.getSql();
        System.out.println(originalSql);
        //如果当前代理的是一个非代理对象，那么它就回调用真实拦截器对象方法，如果不是，它会调度下个插件代理对象的invoke方法。
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
