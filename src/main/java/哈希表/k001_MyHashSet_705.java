package 哈希表;

import org.w3c.dom.Node;

/**
 * 705. 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * 示例：
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 */
public class k001_MyHashSet_705 {

    Node[] nodes = new Node[10009];

    static class Node {
        private int key;
        private Node next;

        private Node(int key) {
            this.key = key;
        }
    }

    int getHash(int key) {
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        hash %= nodes.length;
        return hash;
    }

    /**
     * Initialize your data structure here.
     */
    public k001_MyHashSet_705() {

    }

    public void add(int key) {
        int idx = getHash(key);
        Node loc = nodes[idx], temp = loc;
        if (loc != null) {
            Node pre = null;
            while (temp != null) {
                if (key == temp.key) {
                    return;
                }
                pre = temp;
                temp = temp.next;
            }
            temp = pre;
        }
        Node node = new Node(key);
        if (temp != null) {
            temp.next = node;
        } else {
            nodes[idx] = node;
        }
    }

    public void remove(int key) {
        int idx = getHash(key);
        Node loc = nodes[idx];
        if (loc != null) {
            Node pre = null;
            while (loc != null) {
                if (loc.key == key) {
                    if (pre == null) {
                        nodes[idx] = loc.next;
                    } else {
                        pre.next = loc.next;
                    }
                    return;
                }
                pre = loc;
                loc = loc.next;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int idx = getHash(key);
        Node loc = nodes[idx];
        if (loc != null) {
            while (loc != null) {
                if (loc.key == key) {
                    return true;
                }
                loc = loc.next;
            }
        }
        return false;
    }


}
