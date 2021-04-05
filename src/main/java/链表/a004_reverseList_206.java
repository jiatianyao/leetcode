package 链表;

import common.ListNode;

public class a004_reverseList_206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next ==null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        a004_reverseList_206 a004_reverseList_206 = new a004_reverseList_206();
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = a004_reverseList_206.reverseList(node);
        System.out.println(listNode.val);
    }
}
