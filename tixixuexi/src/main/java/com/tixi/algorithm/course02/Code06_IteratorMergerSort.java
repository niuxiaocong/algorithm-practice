package com.tixi.algorithm.course02;

import java.util.Arrays;
import java.util.Random;

public class Code06_IteratorMergerSort {
    public static void main(String[] args) {
        int times = 5000;
        int min = -100;
        int max = 100;
        int len = 10;
        boolean isRight = true;
        for (int i = 0; i <= times; i++) {
            int[] arr = generArr(len, max, min);
            int[] copyarr = copy(arr);
            mergerSortNotResive(arr);
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

    private static void mergerSortNotResive(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        int N = arr.length;     //数组的长度
        int step = 1;           //步长
        while(step < N){
            int L = 0;
            while(L<N){
                int M = L + step - 1;
                if (M >= N){
                    break;
                }
                int R = Math.min(M+step,N-1);
                merger(arr,L,M,R);
                L = R+1;
            }
            //边界，防止溢出
            if (step>N/2){
                break;
            }
            //步长成倍增长
            step <<= 1;
        }
    }

    private static int[] merger(int[] arr, int left, int mid, int right) {
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
        return arr;
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
