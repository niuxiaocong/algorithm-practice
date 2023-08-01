package com.tixi.algorithm.course11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 前序的方式进行序列化和反序列化
 */
public class Code03_SerializePre {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);

        root.left = node1;
        node1.right = node2;
        Queue<String> result = preSerialize(root);
        for (String s : result) {
            System.out.print(s + ",");
        }

        System.out.println();
        Queue<String> postResult = postSerialize(root);
        for (String s : postResult) {
            System.out.print(s + ",");
        }
        System.out.println();

        Queue<String> levelResult = levelSerialize(root);
        for (String s : levelResult) {
            System.out.print(s + ",");
        }

    }
    // 前序方式序列化
    public static Queue<String> preSerialize(TreeNode head){
        Queue<String> ans = new LinkedList<String>();
        pres(head,ans);
        return ans;
    }

    public static void pres(TreeNode head,Queue<String> ans){
        if (head == null){
            ans.add("#");
        }else{
            ans.add(String.valueOf(head.val));
            pres(head.left,ans);
            pres(head.right,ans);
        }
    }

    public static Queue<String> postSerialize(TreeNode head){
        Queue<String> ans = new LinkedList<String>();
        postProcess(head,ans);
        return ans;
    }

    public static void postProcess(TreeNode head,Queue<String> ans){
        if (head == null){
            ans.add("#");
        }else{
            pres(head.left,ans);
            pres(head.right,ans);
            ans.add(String.valueOf(head.val));
        }
    }


    public static Queue<String> levelSerialize(TreeNode head){
        Queue<String> ans = new LinkedList<String>();
        if (head == null){
            ans.add("#");
        }else{
            ans.add(String.valueOf(head.val));
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(head);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.add(poll.left);
                    ans.add(String.valueOf(poll.left.val));
                }else{
                    ans.add("#");
                }

                if (poll.right!=null){
                    queue.add(poll.right);
                    ans.add(String.valueOf(poll.right.val));
                }else{
                    ans.add("#");
                }
            }
        }
        return ans;
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
