package com.spring_101_200.test_141_150.test_145_mybatis_cachenamespaceref_xml;

import org.junit.Test;

public class Test145_Parse {



    @Test
    public void test3(){
        String sql = "select * from lz_user where id = #{1} ";
       String parseValue = parse("#{","}",sql);
        System.out.println(parseValue);
        System.out.println(0x20);
    }


    public static String parse(String openToken,String   closeToken,String text) {
        StringBuilder builder = new StringBuilder();
        if (text != null && text.length() > 0) {
            char[] src = text.toCharArray();
            int offset = 0;
            int start = text.indexOf(openToken, offset);
            while (start > -1) {
                if (start > 0 && src[start - 1] == '\\') {
                    // the variable is escaped. remove the backslash.
                    builder.append(src, offset, start - offset - 1).append(openToken);
                    offset = start + openToken.length();
                } else {
                    int end = text.indexOf(closeToken, start);
                    if (end == -1) {
                        builder.append(src, offset, src.length - offset);
                        offset = src.length;
                    } else {
                        builder.append(src, offset, start - offset);
                        offset = start + openToken.length();
                        String content = new String(src, offset, end - offset);
                        builder.append("?");
                        offset = end + closeToken.length();
                    }
                }
                start = text.indexOf(openToken, offset);
            }
            if (offset < src.length) {
                builder.append(src, offset, src.length - offset);
            }
        }
        return builder.toString();
    }

}
