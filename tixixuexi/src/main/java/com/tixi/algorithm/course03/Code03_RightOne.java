package com.tixi.algorithm.course03;

/**
 * 提取右侧的1
 * a&(-a)，a&(~a+1)
 */
public class Code03_RightOne {
    public static void main(String[] args) {
        int a = 10;
        getRightOne(a);
    }

    public static void getRightOne(int number){
        int ans = number & -number;
        System.out.println(ans);
    }
}
