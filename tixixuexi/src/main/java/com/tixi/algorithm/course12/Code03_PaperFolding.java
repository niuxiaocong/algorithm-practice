package com.tixi.algorithm.course12;

public class Code03_PaperFolding {
    public static void main(String[] args) {

    }
    public static void printAllFolds(int N) {
        printProcess(1,N,true);
    }
    public static void printProcess(int i,int N,boolean down){
        if (i>N){
            return;
        }
        printProcess(i+1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i+1,N,false);
    }
}
