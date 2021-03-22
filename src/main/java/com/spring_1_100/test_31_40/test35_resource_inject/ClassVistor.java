package com.spring_1_100.test_31_40.test35_resource_inject;

import java.io.*;
import java.util.Arrays;

public class ClassVistor {


    public static void main(String[] args) throws Exception{
        InputStream resource = new FileInputStream(new File("/Users/quyixiao/project/spring_tiny/target/classes/com/spring_1_100/test_31_40/test35_resource_inject/Car.class"));
        byte[] a = readClass(resource,true);
        System.out.println(Arrays.toString(a));


    }

    private static byte[] readClass(final InputStream is, boolean close)
            throws IOException {
        if (is == null) {
            throw new IOException("Class not found");
        }
        try {
            byte[] b = new byte[is.available()];
            int len = 0;
            while (true) {
                int n = is.read(b, len, b.length - len);
                if (n == -1) {
                    if (len < b.length) {
                        byte[] c = new byte[len];
                        System.arraycopy(b, 0, c, 0, len);
                        b = c;
                    }
                    return b;
                }
                len += n;
                if (len == b.length) {
                    int last = is.read();
                    if (last < 0) {
                        return b;
                    }
                    byte[] c = new byte[b.length + 1000];
                    System.arraycopy(b, 0, c, 0, len);
                    c[len++] = (byte) last;
                    b = c;
                }
            }
        } finally {
            if (close) {
                is.close();
            }
        }
    }
}
