package leetcode.editor.cn;


import java.util.*;

/**
 * 146.LRU缓存
 * @author 花木凋零成兰
 * @date 2024-10-04 11:29:10
 */
public class T_146_LruCache {
	 public static void main(String[] args) {
	     //测试代码
         LRUCache lRUCache = new T_146_LruCache().new LRUCache(2);
         lRUCache.put(1, 1); // 缓存是 {1=1}
         lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
         lRUCache.get(1);    // 返回 1

         lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}

         lRUCache.get(2);    // 返回 -1 (未找到)
         lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
         lRUCache.get(1);    // 返回 -1 (未找到)
         lRUCache.get(3);    // 返回 3
         lRUCache.get(4);    // 返回 4
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
//class LRUCache extends LinkedHashMap<Integer, Integer> {
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        super(capacity, 0.75F, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return size() > capacity;
//    }
//}

    class LRUCache {

        class Node {
            int key;
            int value;
            Node pre;
            Node next;
            public Node() {
            }
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, Node> data;
        // 首位节点
        Node head;
        Node tail;
        int capacity;

        public LRUCache(int capacity) {
            this.data = new HashMap<>();
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (data.containsKey(key)) {
                // 节点存在则返回
                Node node = data.get(key);
                // 先删除旧节点位置
                deleteNode(node);
                // 最近访问的节点 移动到链表头部
                moveToHead(node);
                // 返回结果
                return node.value;
            } else {
                return -1;
            }
        }

        // 移动链表节点到头部
        public void moveToHead(Node node) {
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        // 删除节点
        public void deleteNode(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }

        public void put(int key, int value) {
            Node oldNode = data.get(key);
            // 判断节点key是否已存在
            if (oldNode != null) {
                // 删除旧节点
                deleteNode(oldNode);
            }
            // 新增节点
            Node node = new Node(key, value);
            data.put(key, node);
            // 新增节点 应该放在链表头部
            moveToHead(node);
            // 判断节点数是否到达容量
            resize();
        }
        public void resize() {
            if (data.size() > capacity) {
                // 去除链表末尾节点
                Node deleteNode = tail.pre;
                deleteNode.pre.next = tail;
                tail.pre = deleteNode.pre;
                data.remove(deleteNode.key);
            }
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}