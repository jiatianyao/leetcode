package 哈希表;

/**
 * 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 实现 MyHashMap 类：
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * 示例：
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 */
public class k002_MyHashMap_706 {

    static class Node{
        private int key;
        private int value;
        private Node next;
        private Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    int getHash(int key){
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        hash %= nodes.length;
        return hash;
    }

    Node[] nodes = new Node[10009];

    /** Initialize your data structure here. */
    public k002_MyHashMap_706() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = getHash(key);
        Node loc = nodes[idx],temp = loc;
        if(loc !=null){
            Node pre = null;
            while(temp !=null){
                if(key == temp.key){
                    temp.value = value;
                    return;
                }
                pre = temp;
                temp = temp.next;
            }
            temp = pre;
        }
        Node node = new Node(key,value);
        // 头插法
        // node.next = loc;
        // nodes[idx] = node;

        // 尾插法
        if(temp !=null){
            temp.next = node;
        }else{
            nodes[idx] = node;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getHash(key);
        Node loc = nodes[idx];
        if(loc !=null){
            while(loc !=null){
                if(loc.key  == key){
                    return loc.value;
                }else{
                    loc = loc.next;
                }
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getHash(key);
        Node loc = nodes[idx];
        if(loc !=null){
            Node pre = null;
            while (loc !=null){
                if(loc.key == key){
                    if(pre == null){
                        nodes[idx] = loc.next;
                    }else{
                        pre.next = loc.next;
                    }
                    return;
                }
                pre = loc;
                loc = loc.next;
            }
        }
    }
}
