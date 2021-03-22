package com.spring_101_200.test_131_140.test_132_mybatis_typehandlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {
	//使用列名进行封装
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return new PhoneNumber(rs.getString(columnName));
	}
	//使用列的下标进行封装
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int i)
			throws SQLException {
		return new PhoneNumber(rs.getString(i));
	}
	//CallableStatement遇到PhoneNumber，如何设置参数
	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int i)
			throws SQLException {
		return null;
	}
	//PreparedStatement遇到PhoneNumber，如何设置参数
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
									PhoneNumber phoneNumber, JdbcType type) throws SQLException {
		ps.setString(i, phoneNumber.toString());
	}
}