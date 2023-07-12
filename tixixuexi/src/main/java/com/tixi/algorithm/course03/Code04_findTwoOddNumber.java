package com.tixi.algorithm.course03;

/**
 * .两种数出现了奇数次，其余的数出现偶数次，怎么找到出现奇数次的两个数。
 */
public class Code04_findTwoOddNumber {
    public static void main(String[] args) {
        int[] arr = {6,6,6,10,1,1,1,1,2,2,2,2};
        getTwoOddNumber(arr);
    }

    public static void getTwoOddNumber(int[] arr){
        if (arr == null || arr.length == 0){
            return;
        }
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^=  arr[i];
        }
        int rightOne = eor & (-eor);
        int onlyOne  = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) == 0){
                onlyOne ^=  arr[i];
            }
        }

        System.out.println(onlyOne + " " + (eor ^  onlyOne));
    }
}
