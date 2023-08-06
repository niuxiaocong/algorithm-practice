package com.tixi.algorithm.course13;

public class Code08_LowestAncestor {
    public static void main(String[] args) {

    }

    public static TreeNode lowestAncestor2(TreeNode head, TreeNode a, TreeNode b){
        return process(head,a,b).ans;
    }

    public static Info process(TreeNode x, TreeNode a, TreeNode b){
        if (x == null) {
            return new Info(false,false,null);
        }
        Info leftInfo = process(x.left,a,b);
        Info rightInfo = process(x.right,a,b);

        boolean findA = (x == a) || leftInfo.findA || rightInfo.findA;
        boolean findB = (x == b) || leftInfo.findB || rightInfo.findB;
        TreeNode ans = null;
        if (leftInfo.ans!=null){
            ans = leftInfo.ans;
        }else if (rightInfo.ans!=null){
            ans = rightInfo.ans;
        }else{
            if (findA && findB) {
                ans = x;
            }
        }
        return new Info(findA,findB,ans);
    }

    public static class Info{
        boolean findA;
        boolean findB;
        public TreeNode ans;

        public Info(boolean findA, boolean findB, TreeNode ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }
}
