package com.tixi.algorithm.course04;

public class Code01_reverseLinkedList {
    public static void main(String[] args) {
        Node root  = new Node(1);
        Node node1  = new Node(2);
        Node node2  = new Node(3);
        root.next = node1;
        node1.next = node2;


        Node nodeNew = reverse(root);


        System.out.println(nodeNew.val);
    }

    public static Node reverse(Node head){
        Node pre = null;
        Node next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static class Node{
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
