package com.tixi.algorithm.course13;

public class Code04_IsFull {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);

        node1.left = node2;
        //node1.right = node3;

        System.out.println(isFull(node1));
    }

    public static boolean isFull(TreeNode head){
        if (head == null) {
            return true;
        }
        Info all = process(head);
        return (1 << all.height) -1 == all.nodes;
    }

    public static Info process(TreeNode x){
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height, nodes);
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
        public int height;
        public int nodes;

        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }
}
