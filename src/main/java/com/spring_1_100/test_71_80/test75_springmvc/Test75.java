package com.spring_1_100.test_71_80.test75_springmvc;

import org.apache.tools.ant.types.resources.FileResourceIterator;
import org.junit.Test;

public class Test75 {


    @Test
    public void test(){
        String requestUri = "index;abc/test.htm";
        int semicolonIndex = requestUri.indexOf(';');
        while (semicolonIndex != -1) {
            int slashIndex = requestUri.indexOf('/', semicolonIndex);
            String start = requestUri.substring(0, semicolonIndex);
            requestUri = (slashIndex != -1) ? start + requestUri.substring(slashIndex) : start;
            semicolonIndex = requestUri.indexOf(';', semicolonIndex);
        }

        System.out.println(requestUri);
    }


    /**
     *  <p>Detects include request URL if called within a RequestDispatcher include.
     * 	 * <p>E.g.: servlet mapping = "/*"; request URI = "/test/a" -> "/test/a".
     * 	 * <p>E.g.: servlet mapping = "/"; request URI = "/test/a" -> "/test/a".
     * 	 * <p>E.g.: servlet mapping = "/test/*"; request URI = "/test/a" -> "/a".
     * 	 * <p>E.g.: servlet mapping = "/test"; request URI = "/test" -> "".
     * 	 * <p>E.g.: servlet mapping = "/*.test"; request URI = "/a.test" -> "".
     * 	 * @param request current HTTP request
     * 	 * @return the path within the servlet mapping, or ""
     */

    @Test
    public void test2(){
        String requestUri = "/test/a/index.html";
        String mapping = "";
        String result = getRemainingPath(requestUri,mapping,false);
        System.out.println(result);
    }


    public static String getRemainingPath(String requestUri, String mapping, boolean ignoreCase) {
        int index1 = 0;
        int index2 = 0;
        for (; (index1 < requestUri.length()) && (index2 < mapping.length()); index1++, index2++) {
            char c1 = requestUri.charAt(index1);
            char c2 = mapping.charAt(index2);
            if (c1 == ';') {
                index1 = requestUri.indexOf('/', index1);
                if (index1 == -1) {
                    return null;
                }
                c1 = requestUri.charAt(index1);
            }
            if (c1 == c2) {
                continue;
            }
            else if (ignoreCase && (Character.toLowerCase(c1) == Character.toLowerCase(c2))) {
                continue;
            }
            return null;
        }
        if (index2 != mapping.length()) {
            return null;
        }
        else if (index1 == requestUri.length()) {
            return "";
        }
        else if (requestUri.charAt(index1) == ';') {
            index1 = requestUri.indexOf('/', index1);
        }
        return (index1 != -1 ? requestUri.substring(index1) : "");
    }
}
