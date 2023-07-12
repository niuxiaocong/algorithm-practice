package com.tixi.algorithm.course03;

public class Code01_Swap {
    public static void main(String[] args) {
        //使用这个方式交换的前提是在内存中不是同一个位置
        int a = 7;
        int b = 13;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}
