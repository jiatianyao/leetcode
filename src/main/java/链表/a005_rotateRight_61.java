package 链表;

import common.ListNode;

public class a005_rotateRight_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(k ==0 || head == null || head.next ==null) return head;
        ListNode cur = head;
        int len = 1;
        while(cur.next !=null){
            cur = cur.next;
            len++;
        }
        cur.next = head;
        k = k%len;
        if(k==len) return head;
        k = len-k-1;
        while(k-->0){
            head = head.next;
        }
        cur = head.next;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        a005_rotateRight_61 a005_rotateRight_61 = new a005_rotateRight_61();
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = a005_rotateRight_61.rotateRight(node,2);
        System.out.println(listNode.val);
    }
}
