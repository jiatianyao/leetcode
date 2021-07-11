package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class daily_0710_TimeMap_981 {
    class Node {
        String k, v;
        int t;
        Node (String key, String value, int time) {
            k = key; v = value; t = time;
        }
    }

    Map<String, List<Node>> map = new HashMap<>();

    public void set(String k, String v, int t) {
        List<Node> list = map.getOrDefault(k, new ArrayList<>());
        list.add(new Node(k, v, t));
        map.put(k, list);
    }

    public String get(String k, int t) {
        List<Node> list = map.getOrDefault(k, new ArrayList<>());
        if (list.isEmpty()) return "";
        int n = list.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid).t <= t) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return list.get(r).t <= t ? list.get(r).v : "";
    }

}
