package com.tixi.algorithm.course13;

public class Code03_isBst {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);


        node1.left = node2;
        node1.right = node3;

        System.out.println(isbst(node1));

    }


    public static boolean isbst(TreeNode head){
        return process(head).isBst;
    }


    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int max = x.val;
        int min = x.val;

        if (leftInfo!=null){
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        }

        if (rightInfo!=null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(max, rightInfo.min);
        }
        boolean isBst = true;

        if (leftInfo!=null && !leftInfo.isBst) {
            isBst = false;
        }
        if (rightInfo!=null && !rightInfo.isBst) {
            isBst = false;
        }
        if (leftInfo!=null && leftInfo.max >= x.val) {
            isBst = false;
        }
        if (rightInfo!=null && rightInfo.min <= x.val) {
            isBst = false;
        }
        return new Info(isBst, max, min);
    }
    public static class Info {
        public boolean isBst;
        public int max;
        public int min;
        public Info(boolean isBst, int max, int min) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
        }
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
