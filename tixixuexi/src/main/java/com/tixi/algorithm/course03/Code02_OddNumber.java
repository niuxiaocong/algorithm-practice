package com.tixi.algorithm.course03;

/**
 * 在数组中有一种数出现了奇数次，其他的数都 出现了偶数次，怎么找到这个出现奇数次的这个数
 */
public class Code02_OddNumber {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3};
        int oddNumber = getOddNumber(arr);
        System.out.println("odd number  =  " + oddNumber);
    }

    public static int getOddNumber(int[] arr){
        if (arr == null || arr.length ==0){
            return -1;
        }
        int target = 0;
        for (int i=0;i<arr.length;i++){
            target ^= arr[i];
        }
        return target;
    }
}
