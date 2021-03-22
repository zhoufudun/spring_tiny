package com.spring_101_200.test_111_120.test_117_excution.excution0;

public class TestMatch {


    public static void main(String[] args) {
        System.out.println(matches());
    }





    public static boolean matches() {
        int starCount = 1 ;
        char[] a1 = {'a', 'b', '*','f'};
        char[] a2 = {'a', 'b', 'c','d','e'};
        int len1 = a1.length;
        int len2 = a2.length;
        //如果字符数组中一个*都没有的情况
        if (starCount == 0) {
            //两字符串长度不相等，则肯定不匹配
            if (len1 != len2) {
                return false;
            }
            //否则，一个一个进行匹配
            for (int i = 0; i < len1; i++) {
                if (a1[i] != a2[i]) {
                    return false;
                }
            }
            return true;
        } else if (starCount == 1) {        //如果表达式中有一个*号的情况
            if (len1 == 1) {
                return true;
            }
            //如果表达式中有*号，而且长度还大于目标方法字符数组，返回 false
            if (len1 > len2 + 1) {
                return false;
            }
            int i2 = 0;
            for (int i1 = 0; i1 < len1; i1++) {
                char c1 = a1[i1];
                //*吃掉多余字符
                if (c1 == '*') {
                    i2 = len2 - (len1 - (i1 + 1));
                } else if (c1 != a2[i2++]) {//没有遇到*号时，逐个进行匹配，字符不相等，返回 false
                    return false;
                }
            }
            return true;
        }


        return false;
    }

}


