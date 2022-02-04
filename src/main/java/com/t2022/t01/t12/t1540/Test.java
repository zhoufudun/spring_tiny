package com.t2022.t01.t12.t1540;

public class Test {

    // String中的equals方法是被重写的，因为object的equals方法是比较对象的内存地址，而String的equals方法比较的是对象的值
    // 当创建String类型的对象时，虚拟机会在常量池中查找有没有存在的值和要创建的值相同的对象，如果有，就把它赋值给当前引用，如果没有就在常量池中
    // 重新创建一个String对象
    public static void main(String[] args) {
        String a = new String ("ab");
        String b = new String("ab");
        String aa = "ab";// 放在常量池中
        String bb = "ab";// 从常量池中查找

        if(aa == bb ){
            System.out.println("aa == bb ");
        }
        if(a == b ){// false ,非同一个对象
            System.out.println("a == b ");
        }
        if(a .equals(b )){
            System.out.println("aEQb");
        }
        if(42 == 42.0){
            System.out.println("true");
        }
    }
}
