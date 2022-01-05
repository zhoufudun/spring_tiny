package com.spring_101_200.test_191_200.test_199_jvm;

public class TestTenuringThreshold {



    private static final int _1MB  = 1024 *1024;

    /**
     * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:Survivor-
     Ratio=8 -XX:MaxTenuringThreshold=1 * -XX:+PrintTenuringDistribution
     */
    public static void main(String[] args) {
        byte [] allocation1 ,allocation2 ,allocation3 ;

        allocation1 = new byte[4 * _1MB];
        allocation2 = new byte [ 4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }




}
