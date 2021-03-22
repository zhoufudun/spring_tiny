package com.spring_101_200.test_191_200.test_197_directFieldAccessor;


import java.util.Map;

public class RiskData {


    // mapping：为映射成风控的字段，convertService为类型转换器，dateFormate为日期格式，sql 表示我们要查询数据库的 sql,defaultValue表示，如果数据库中没有，则取该值传风控
    @ISelects({
            @ISelect(sql = "select gmt_create from lz_user where id = #{id}", mapping = "gmtCreate", dateFormate = "yyyy-MM-dd", desc = "用户注册时间"),
            @ISelect(sql = "select gmt_create from lz_user_log where id = #{id}", mapping = "user", convertService = IDateConvert.class, desc = "用户最后一次登陆时间")
    }
    )
    // #{userName} ，#{id}表示方法返回值
    @ITables({
            @ITable(tableName = "lsd_user",value = User.class, wheres = {
                    @IWhere(column = "username", value = "#{userName}"),
                    @IWhere(column = "id", value = "#{id}"),
            }
            ),
            @ITable(tableName = "lsd_user_log", value = User.class,columns = {
                    @IColumn(column = "username", mapping = "userName", defaultValue = "1")
            })
    })
    private Map<String, Object> map;

}
