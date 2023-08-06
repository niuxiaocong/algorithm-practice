package com.tixi.algorithm.course12;

import com.tixi.algorithm.course11.Code02_notRecursionTreePrint;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Code01_TreeMaxWidth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        System.out.println(maxWidthMap(root));
    }

    public static int maxWidthMap(TreeNode head) {
        if (head == null) {
            return 0;
        }
        // 用来记录当前节点在那一层
        Map<TreeNode, Integer> levelMap = new HashMap();
        levelMap.put(head, 1);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(head);

        // 统计当前层的层数
        int currentLevel = 1;
        // 统计当前层的节点数量
        int currentLevelNodes = 1;
        int max = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 获取当前几点在第几层
            Integer curNodeLevel = levelMap.get(node);
            if (node.left != null) {
                levelMap.put(node.left, curNodeLevel + 1);
                queue.add(node.left);
            }
            if (node.right != null) {
                levelMap.put(node.right, curNodeLevel + 1);
                queue.add(node.right);
            }

            // 当前节点所在层和当前层相等
            if (curNodeLevel == currentLevel) {
                max = Math.max(max, currentLevelNodes);
                currentLevel++;
                currentLevelNodes = 1;
            } else {
                currentLevelNodes++;
            }
        }
        return Math.max(max, currentLevelNodes);
    }



    public static int maxWidth(TreeNode head){
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode curNode = head;
        TreeNode nextNode = null;
        int max = 0;
        int curLevelNodes = 0;
        queue.add(head);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();

            if (cur.left!=null){
                queue.add(cur.left);
                nextNode = cur.left;
            }

            if (cur.right!=null){
                queue.add(cur.right);
                nextNode = cur.right;
            }

            curLevelNodes++;

            if (cur == curNode) {
                max = Math.max(max,curLevelNodes);
                curLevelNodes = 0;
                curNode = nextNode;
            }
        }
        return  max;
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
