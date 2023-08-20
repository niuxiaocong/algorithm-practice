package com.tixi.algorithm.course15;

public class Code04_smallLight {
    public static void main(String[] args) {

    }

    public static int smallLight(String str){
        char[] chars = str.toCharArray();
        // 需要放灯的数量
        int lightCount = 0;
        int i = 0;
        while(i < chars.length){
            if (chars[i] == 'X') {
                i++;
            }else {
                lightCount++;
                if (i+1 == chars.length) {
                    break;
                }else {
                    if (chars[i+1] == 'X') {
                        i = i+2;
                    }else {
                        i = i+3;
                    }
                }
            }
        }
        return lightCount;
    }
}
