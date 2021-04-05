package 链表;

import common.ListNode;

public class a006_reverseBetween_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode begin = new ListNode(0,head);
        ListNode beginIndex = begin;
        ListNode middle = null;
        ListNode middleIndex = null;
        ListNode end = null;
        for (int i = 1; i <= right; i++) {

            if(i<left){
                beginIndex = beginIndex.next;
            }else if(i==left){
                middle = beginIndex.next;
                middleIndex = middle;
                beginIndex.next = null;
            }else if(i==right){
                middleIndex = middleIndex.next;
                end = middleIndex.next;
                middleIndex.next = null;
            }else{
                middleIndex = middleIndex.next;
            }
            head = head.next;
        }
        ListNode listNode = reverseList(middle);
        middle = listNode;
        while(middle.next!=null){
            middle = middle.next;
        }
        middle.next = end;
        beginIndex.next = listNode;
        return begin.next;
    }

    public ListNode reverseList(ListNode head) {
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



}
