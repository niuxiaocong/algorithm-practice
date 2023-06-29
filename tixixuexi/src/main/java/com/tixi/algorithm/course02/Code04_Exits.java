package com.tixi.algorithm.course02;
/**
 * 二分
 */
public class Code04_Exits {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,2,3,4,5,6};
        System.out.println(exits(arr, 1));
        System.out.println(leftIndexx(arr,1));
    }

    //模板
    public static int exits(int[] sortArr , int target){
        if (sortArr == null || sortArr.length == 0){
            return -1;
        }
        int L = 0;
        int R = sortArr.length - 1;
        int mid = 0;
        while(L<R){
            mid = L + ((R-L)>>1);
            if (sortArr[mid] == target){
                return mid;
            }else if (sortArr[mid] > target){
                R = mid - 1;
            }else if (sortArr[mid] < target){
                L = mid + 1;
            }
        }
        return -1;
    }

    public static int leftIndexx(int[] sortArr , int target){
        if (sortArr == null || sortArr.length == 0){
            return -1;
        }
        int L = 0;
        int R = sortArr.length - 1;
        int mid = 0;
        int index = -1;
        while(L<R){
            mid = L + ((R-L)>>1);
            if (sortArr[mid] >= target){
                index = mid;
                R = mid - 1;
            }else{
                L = mid+1;
            }
        }
        return index;
    }
}
