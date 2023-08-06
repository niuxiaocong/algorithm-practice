package com.tixi.algorithm.course13;

public class Code06_MaxSubTree {
    public static void main(String[] args) {

    }

    public static int maxBstNodes(TreeNode head){
        if (head == null) {
            return 0;
        }
        return process(head).maxBstSubTreeSize;
    }

    public static Info process(TreeNode x){
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int max = x.val;
        int min = x.val;
        int allSize = 1;
        if (leftInfo!=null){
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.min, min);
            allSize += leftInfo.allSize;
        }

        if (rightInfo!=null){
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
            allSize += rightInfo.allSize;
        }

        int p1 = -1;
        if (leftInfo!=null){
            p1 = leftInfo.maxBstSubTreeSize;
        }
        int p2 = -1;
        if (rightInfo!=null){
            p2 = rightInfo.maxBstSubTreeSize;
        }
        int p3 = -1;
        // 过头节点
        boolean leftBST = leftInfo == null ? true : (leftInfo.maxBstSubTreeSize == leftInfo.allSize);
        boolean rightBST = rightInfo == null ? true : (rightInfo.maxBstSubTreeSize == rightInfo.allSize);
        if (leftBST && rightBST) {
            boolean leftMaxLessX = leftInfo == null ? true : (leftInfo.max < x.val);
            boolean rightMinMoreX = rightInfo == null ? true : (x.val < rightInfo.min);
            if (leftMaxLessX && rightMinMoreX) {
                int leftSize = leftInfo == null ? 0 : leftInfo.allSize;
                int rightSize = rightInfo == null ? 0 : rightInfo.allSize;
                p3 = leftSize + rightSize + 1;
            }
        }
        return new Info(Math.max(p1,Math.max(p2,p3)),allSize,max,min);
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
        public int maxBstSubTreeSize;
        public int allSize;
        public int max;
        public int min;
        public Info(int maxBstSubTreeSize, int allSize, int max, int min) {
            this.maxBstSubTreeSize = maxBstSubTreeSize;
            this.allSize = allSize;
            this.max = max;
            this.min = min;
        }
    }
}
