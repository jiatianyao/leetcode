package 链表;

import common.ListNode;

public class a007_swapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode p = node;
        if(head ==null || head.next ==null) return head;
        while(head !=null && head.next !=null){

            ListNode a = new ListNode(head.val);
            ListNode b = new ListNode(head.next.val);
            p.next = b;
            b.next = a;
            head = head.next.next;
            p = p.next.next;
        }
        if(head !=null){
            p.next = head;
        }
        return node.next;
    }

    public static void main(String[] args) {
        a007_swapPairs_24 fuction = new a007_swapPairs_24();
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode listNode = fuction.swapPairs(node);
        System.out.println(listNode.val);
    }
}
