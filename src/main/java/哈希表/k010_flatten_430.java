package 哈希表;

public class k010_flatten_430 {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };


    public Node flatten(Node head) {
        if(head == null) return null;
        Node p = head,q,k;
        while (p !=null){
            k = null;
            if(p.child !=null){
                k = flatten(p.child);
                p.child = null;
                q = p.next;
                p.next = k;
                k.prev = p;
                while(p.next !=null){
                    p = p.next;
                }
                p.next = q;
                if(q!=null){
                    q.prev = p;
                }
            }
            p = p.next;
        }
        return head;
    }
}
