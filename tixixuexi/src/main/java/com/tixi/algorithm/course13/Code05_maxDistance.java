package com.tixi.algorithm.course13;

/**
 * 二叉树的最远距离
 */

public class Code05_maxDistance {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        maxDistance(node1);
    }

    public static int maxDistance(TreeNode head){
        return process(head).maxDistance;
    }

    public static Info process(TreeNode x){
        if (x == null){
            return new Info(0,0);
        }

        Info leftTreeInfo = process(x.left);
        Info rightTreeInfo = process(x.right);
        int height = Math.max(leftTreeInfo.height ,rightTreeInfo.height) + 1;
        int leftMaxDistince = leftTreeInfo.maxDistance;
        int rightMaxDistince = rightTreeInfo.maxDistance;
        int maxDistance = Math.max(leftMaxDistince,Math.max(rightMaxDistince,leftMaxDistince + rightMaxDistince +1));
        return new Info(height,maxDistance);
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static class Info {
        public int maxDistance;
        public int height;
        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }
}
