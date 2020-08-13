package com.guomn.toolbox.demo.ameituan;

/**
 * 单链表反转
 */
public class LinkedListRevert {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.setNest(n2);
        n2.setNest(n3);
        n3.setNest(n4);

//        ListNode newList =
    }




}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    public void setNest(ListNode next) {
        this.next = next;
    }
}
