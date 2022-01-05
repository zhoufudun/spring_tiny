package com.spring_101_200.test_191_200.test_200_t;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class OneValueCache {

    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] lastFactors) {
        this.lastNumber = i;
        this.lastFactors = lastFactors;
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors, lastFactors.length);
    }

    public static void main(String[] args) {
        byte [] i = new byte []{1,4};
        byte [] j = new byte []{2};
        byte [] k = new byte []{3};
        OneValueCache oneValueCache = new OneValueCache(new BigInteger(i),new BigInteger[]{new BigInteger(i),new BigInteger(j),new BigInteger(k)});
        BigInteger[] x = oneValueCache.getFactors(new BigInteger(i));
        for(BigInteger n : x){
            System.out.println(n);
        }


    }
}
