package 每日一题;

import common.ListNode;

public class daily_0721_getIntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pa =headA,pb=headB;
        while(pa!=pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
