package com.tixi.algorithm.course15;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code03_IPO {
    public static void main(String[] args) {

    }

    /**
     *
     * @param k         最多个项目
     * @param w         是初始资金
     * @param profits / capital 一定是等长度
     * @return
     */
    public static int findMaxinizedCapital(int k, int w, int[] profits, int[] capital){
        // 准备两个堆
        PriorityQueue<Program> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Program> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());

        for (int i=0;i<profits.length;i++) {
            minCostQ.add(new Program(profits[i],capital[i]));
        }
        for (int i=0;i<k;i++) {
            while(!minCostQ.isEmpty() && minCostQ.peek().c <= w){
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }
    public static class Program {
        public int p;
        public int c;

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
    // 资金
    public static class MinCostComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.c - o2.c;
        }

    }
    // 利润
    public static class MaxProfitComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o2.p - o1.p;
        }
    }
}
