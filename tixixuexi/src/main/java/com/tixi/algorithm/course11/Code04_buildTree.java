package com.tixi.algorithm.course11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 反序列化一颗二叉树
 */
public class Code04_buildTree {

    public static void main(String[] args) {
        Queue<String> preQueue = new LinkedList<String>();
        preQueue.add("1");
        preQueue.add("1");
        preQueue.add("#");
        preQueue.add("1");
        preQueue.add("#");
        preQueue.add("#");
        preQueue.add("#");

        Queue<String> postQueue = new LinkedList<String>();
        postQueue.add("1");
        postQueue.add("#");
        postQueue.add("1");
        postQueue.add("#");
        postQueue.add("#");
        postQueue.add("#");
        postQueue.add("1");

        Queue<String> levelQueue = new LinkedList<String>();
        levelQueue.add("1");
        levelQueue.add("1");
        levelQueue.add("#");
        levelQueue.add("#");
        levelQueue.add("1");
        levelQueue.add("#");
        levelQueue.add("#");

        TreeNode preHead = preBuild(preQueue);

        System.out.println("----------------------------");

        TreeNode levelHead = levelBuild(levelQueue);


    }

    public static TreeNode preBuild(Queue<String> queue){
        if (queue == null || queue.isEmpty()) {
            return null;
        }
        return preProcess(queue);
    }

    public static TreeNode preProcess(Queue<String> queue){
        String value = queue.poll();
        if ("#".equals(value)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = preProcess(queue);
        root.right = preProcess(queue);
        return root;
    }

//    public static TreeNode postBuild(Queue<String> queue){
//        if (queue == null || queue.isEmpty()) {
//            return null;
//        }
//        return postProcess(queue);
//    }
//
//    public static TreeNode postProcess(Queue<String> queue){
//        String value = queue.poll();
//        if ("#".equals(value)){
//            return null;
//        }
//        root.left = postProcess(queue);
//        root.right = postProcess(queue);
//        TreeNode root = new TreeNode(Integer.parseInt(value));
//        return root;
//    }

    public static TreeNode levelBuild(Queue<String> levelList){
        if (levelList == null || levelList.isEmpty()) {
            return null;
        }
        TreeNode head = generateNode(levelList.poll());

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (head != null) {
            queue.add(head);
        }
        TreeNode node = null;
        while(!queue.isEmpty()){
             node = queue.poll();
             node.left = generateNode(levelList.poll());
             node.right = generateNode(levelList.poll());
             if (node.left!=null) {
                 queue.add(node.left);
             }
             if (node.right!=null){
                 queue.add(node.right);
             }
        }
        return head;
    }

    public static TreeNode generateNode(String val){
        if (val == "#"){
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
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
