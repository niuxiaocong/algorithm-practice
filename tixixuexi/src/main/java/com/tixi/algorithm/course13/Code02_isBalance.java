package com.tixi.algorithm.course13;

public class Code02_isBalance {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);



        root.left = node1;
        root.right = node2;

        System.out.println(isBanance(root));
    }

    // 收集的信息体
    public static class Info{
        public boolean isBalance;
        public int height;
        public Info(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public static boolean isBanance(TreeNode head){
        return process(head).isBalance;
    }

    public static Info process(TreeNode x){
        if (x == null) {
            return new Info(true,0);
        }
        Info leftInfo = process(x.left);
        Info riggthInfo = process(x.right);

        int heigth = Math.max(leftInfo.height, riggthInfo.height) + 1;
        boolean balanced = true;
        if (!leftInfo.isBalance) {
            balanced = false;
        }
        if (!riggthInfo.isBalance){
            balanced = false;
        }
        if (Math.abs(leftInfo.height - riggthInfo.height) >1) {
            balanced = false;
        }

        return new Info(balanced, heigth);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
