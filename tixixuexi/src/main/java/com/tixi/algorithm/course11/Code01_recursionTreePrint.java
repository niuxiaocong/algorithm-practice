package com.tixi.algorithm.course11;

public class Code01_recursionTreePrint {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        pre(root);

    }

    public static void pre(TreeNode head){
        if (head == null){
            return;
        }
        System.out.println(head.val);
        pre(head.left);
        pre(head.right);
    }

    public static void mid(TreeNode head){
        if (head == null){
            return;
        }
        pre(head.left);
        System.out.println(head.val);
        pre(head.right);
    }

    public static void after(TreeNode head){
        if (head == null){
            return;
        }
        pre(head.left);
        pre(head.right);
        System.out.println(head.val);
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
