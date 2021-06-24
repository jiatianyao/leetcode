package common;

import java.util.*;

public class BFSFramework {
    class Node{
        int val;
        List<Node> adj;
    }
    int BFS(Node start,Node target){
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(start);
        set.add(start);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                 Node cur = queue.poll();
                 if(cur.val == target.val) return step;
                for (Node node : cur.adj) {
                    if(!set.contains(node)){
                        queue.offer(node);
                        set.add(node);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
