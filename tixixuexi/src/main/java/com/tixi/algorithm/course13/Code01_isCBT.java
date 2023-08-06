package com.tixi.algorithm.course13;

import java.util.LinkedList;
import java.util.Queue;

public class Code01_isCBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);



        root.left = node1;
        root.right = node2;

        //node1.right = node3;

        System.out.println(isCbt(root));

    }

    public static boolean isCbt(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean isLeaf = false;
        queue.add(head);
        while(!queue.isEmpty()){
            // 当前树节点
            TreeNode curTreeNode = queue.poll();
            TreeNode left = curTreeNode.left;
            TreeNode right = curTreeNode.right;
            if (
                    (isLeaf && (left != null || right != null))
                    ||
                    (left == null && right != null)
            ) {
                return false;
            }

            if (left!=null) {
                queue.add(left);
            }

            if (right!=null){
                queue.add(right);
            }
            if (left == null && right == null) {
                isLeaf = true;
            }
        }
        return true;
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
