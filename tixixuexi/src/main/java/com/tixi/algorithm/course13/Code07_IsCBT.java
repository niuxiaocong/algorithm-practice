package com.tixi.algorithm.course13;

public class Code07_IsCBT {
    public static void main(String[] args) {

    }


    public static boolean isCBT(TreeNode head){
        if (head == null) {
            return true;
        }
        return process(head).isCBT;
    }

    public static Info process(TreeNode x){
        if (x == null) {
            return new Info(true,true,0);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        boolean isCBT = false;
        if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height) {
            isCBT = true;
        }
        if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isCBT = true;
        }
        if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1) {
            isCBT = true;
        }
        if (leftInfo.isFull && rightInfo.isCBT && leftInfo.height == rightInfo.height) {
            isCBT = true;
        }
        return new Info(isFull,isCBT,height);
    }

    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static class Info{
        public boolean isFull;
        public boolean isCBT;
        public int height;
        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }
}
