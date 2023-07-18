package com.tixi.algorithm.course11;

import java.util.Stack;

public class Code02_notRecursionTreePrint {
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
        System.out.println("+++++++++++++++++++++++++++");
        post(root);
        System.out.println("+++++++++++++++++++++++++++");
        mid(root);
    }

    public static void pre(TreeNode head){
        if (head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(head);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
        }
    }

    public static void mid(TreeNode head){
        if (head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = head;
        while(!stack.isEmpty() || cur!=null){
            if (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }
    public static void post(TreeNode head){
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();

        stack1.push(head);
        while(!stack1.isEmpty()){
            TreeNode cur = stack1.pop();
            stack2.push(cur);
            if (cur.left!=null){
                stack1.push(cur.left);
            }
            if (cur.right!=null){
                stack1.push(cur.right);
            }
        }
        while(!stack2.isEmpty()){
            TreeNode treeNode = stack2.pop();
            System.out.println(treeNode.val);

        }
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
