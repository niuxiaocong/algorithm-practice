package com.tixi.algorithm.course15;

import java.util.PriorityQueue;

public class Code02_lessMoneySplitGold {
    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30};
        int i = lessMoneySplitGoldM1(arr);
        System.out.println(i);
    }

    public static int lessMoneySplitGoldM1(int[] arr){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();
        for (int i=0;i<arr.length;i++){
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while(pQ.size() > 1){
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
}
