package com.tixi.algorithm.course02;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 */
public class Code05_MergerSort {
    public static void main(String[] args) {
        int times = 5000;
        int min = -100;
        int max = 100;
        int len = 10;
        boolean isRight = true;
        for (int i = 0; i <= times; i++) {
            int[] arr = generArr(len, max, min);
            int[] copyarr = copy(arr);
            mergerSort(arr);
            Arrays.sort(copyarr);
            for (int j=0;j<len;j++){
                if (arr[j]!=copyarr[j]){
                    isRight = false;
                }
                if (!isRight){
                    System.out.println("出错啦！" + arr.toString());
                    return;
                }
            }
        }
        if (isRight) {
            System.out.println("finish");
        }
    }

    // 归并函数
    public static void mergerSort(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        process(arr,0,arr.length-1);
    }

    // 递归函数
    public static void process(int[] arr, int L, int R){
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L,mid);
        process(arr,mid+1,R);
        merger(arr,L,mid,R);
    }

    private static void merger(int[] arr, int left, int mid, int right) {
        int[] help = new int[right-left+1];
        int p1 = left;
        int p2 = mid+1;
        int index = 0;
        while(p1<=mid && p2<=right){
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= mid){
            help[index++] = arr[p1++];
        }

        while(p2<=right){
            help[index++] = arr[p2++];
        }

        for (int i=0 ; i<help.length ; i++){
            arr[left + i] = help[i];
        }
    }

    // for test
    public static int[] copy(int[] arr){
        if (arr == null || arr.length == 0){
            return new int[0];
        }
        int[] arrCopy =  new int[arr.length];
        for (int i=0;i<arr.length;i++){
            arrCopy[i] = arr[i];
        }
        return arrCopy;
    }

    public static int[] generArr(int len,int max,int min){
        Random rand = new Random();
        int[] arr = new int[len];
        for (int i=0;i<arr.length-1;i++){
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }


}
