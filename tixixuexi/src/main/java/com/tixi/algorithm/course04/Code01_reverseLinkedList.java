package com.tixi.algorithm.course04;

public class Code01_reverseLinkedList {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode ListNode1 = new ListNode(2);
        ListNode ListNode2 = new ListNode(3);
        ListNode ListNode3 = new ListNode(4);
        ListNode ListNode4 = new ListNode(5);

        root.next = ListNode1;
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode4;

        ListNode head = reverseSingleList(root);

        while(head !=null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static ListNode reverseSingleList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = null;
        ListNode pre = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

