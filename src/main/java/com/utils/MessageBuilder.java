package com.utils;


public class MessageBuilder {

	public static String buildMessage(String code,String msg) {
		StringBuilder message=new StringBuilder();
		message.append(" Response : ");
		message.append(msg);
		message.append("(");
		message.append(code);
		message.append(")");
		return message.toString();
	}
	
}
