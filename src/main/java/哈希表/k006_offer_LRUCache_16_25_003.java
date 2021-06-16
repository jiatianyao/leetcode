package 哈希表;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.25. LRU 缓存
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。
 * 缓存应该从键映射到值(允许你插入和检索特定键对应的值)，
 * 并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache(2);//2缓存容量
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
public class k006_offer_LRUCache_16_25_003 {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public k006_offer_LRUCache_16_25_003(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = head;

    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode pre = map.get(key);
        ListNode cur = pre.next;
        if(cur != tail){
            pre.next = cur.next;
            map.put(cur.next.key,pre);
            map.put(cur.key,tail);
            moveTotail(cur);
        }
        return cur.val;
    }

    public void put(int key, int value) {
        if(get(key)!=-1){
            map.get(key).next.val = value;
            return;
        }
        ListNode node = new ListNode(key,value);
        map.put(key,tail);
        moveTotail(node);

        if(map.size() > capacity){
            map.remove(head.next.key);
            map.put(head.next.next.key,head);
            head.next = head.next.next;
        }
    }

    private void moveTotail(ListNode node) {
        node.next = null;
        tail.next = node;
        tail = tail.next;
    }

    static class ListNode{
        private int key;
        private int val;
        private ListNode next;

        public ListNode(int key,int val){
            this.key = key;
            this.val = val;
            next = null;
        }
    }
}


