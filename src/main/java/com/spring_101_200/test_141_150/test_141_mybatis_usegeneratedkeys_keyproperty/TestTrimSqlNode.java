package com.spring_101_200.test_141_150.test_141_mybatis_usegeneratedkeys_keyproperty;

import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.session.Configuration;

import java.util.*;

public class TestTrimSqlNode {


    public static void main(String[] args) {
        StringBuilder sqlBuffer = new StringBuilder("set abc ,");
        String[] prefixesToOverride = new String[]{"SET"};
        String prefix = "set";
        String[] suffixesToOverride = new String[]{","};
        String suffix = "";
        MyFilteredDynamicContext myFilteredDynamicContext = new MyFilteredDynamicContext(sqlBuffer, prefixesToOverride, prefix, suffixesToOverride, suffix);
        System.out.println(myFilteredDynamicContext.applyAll());
    }


    public static class MyFilteredDynamicContext {
        private boolean prefixApplied;
        private boolean suffixApplied;
        private StringBuilder sqlBuffer;
        private String[] prefixesToOverride;
        private String prefix;
        private String[] suffixesToOverride;
        private String suffix;


        public MyFilteredDynamicContext(StringBuilder sqlBuffer, String[] prefixesToOverride, String prefix, String[] suffixesToOverride, String suffix) {
            this.prefixesToOverride = prefixesToOverride;
            this.prefix = prefix;
            this.suffixesToOverride = suffixesToOverride;
            this.suffix = suffix;
            this.prefixApplied = false;
            this.suffixApplied = false;
            this.sqlBuffer = sqlBuffer;
        }

        public String applyAll() {
            sqlBuffer = new StringBuilder(sqlBuffer.toString().trim());
            String trimmedUppercaseSql = sqlBuffer.toString().toUpperCase(Locale.ENGLISH);
            if (trimmedUppercaseSql.length() > 0) {
                applyPrefix(sqlBuffer, trimmedUppercaseSql);
                applySuffix(sqlBuffer, trimmedUppercaseSql);
            }
            return sqlBuffer.toString();
        }

        private void applyPrefix(StringBuilder sql, String trimmedUppercaseSql) {
            if (!prefixApplied) {
                prefixApplied = true;
                if (prefixesToOverride != null) {
                    for (String toRemove : prefixesToOverride) {
                        if (trimmedUppercaseSql.startsWith(toRemove)) {
                            sql.delete(0, toRemove.trim().length());
                            break;
                        }
                    }
                }
                if (prefix != null) {
                    sql.insert(0, " ");
                    sql.insert(0, prefix);
                }
            }
        }

        private void applySuffix(StringBuilder sql, String trimmedUppercaseSql) {
            if (!suffixApplied) {
                suffixApplied = true;
                if (suffixesToOverride != null) {
                    for (String toRemove : suffixesToOverride) {
                        if (trimmedUppercaseSql.endsWith(toRemove) || trimmedUppercaseSql.endsWith(toRemove.trim())) {
                            int start = sql.length() - toRemove.trim().length();
                            int end = sql.length();
                            sql.delete(start, end);
                            break;
                        }
                    }
                }
                if (suffix != null) {
                    sql.append(" ");
                    sql.append(suffix);
                }
            }
        }

    }
}


