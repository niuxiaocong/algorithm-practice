package com.tixi.algorithm.course02;
import java.util.Arrays;
import java.util.Random;

public class Code01_BubbleSort {
    public static void main(String[] args) {
        int times = 5000;
        int min = -100;
        int max = 100;
        int len = 10;
        boolean isRight = true;
        for (int i = 0; i <= times; i++) {
            int[] arr = generArr(len, max, min);
            int[] copyarr = copy(arr);
            bubbleSort(arr);
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

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0){
            return;
        }
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public static void swap(int[] arr , int i , int j){
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
