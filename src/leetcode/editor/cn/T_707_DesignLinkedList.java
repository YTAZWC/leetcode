package leetcode.editor.cn;


/**
 * 设计链表
 * @author 花木凋零成兰
 * @date 2023-12-06 11:27:25
 */
public class T_707_DesignLinkedList {
	 public static void main(String[] args) {
	     //测试代码
         MyLinkedList solution = new T_707_DesignLinkedList().new MyLinkedList();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
// class MyLinkedList {
//
//     ListNode preNode;      // 链表头节点的前一个节点 即虚拟头节点
//     int size;
//
//     ListNode endNode;   // 用于记录最后一个节点
//
//     public MyLinkedList() {
//         preNode = new ListNode(-1);   // 初始化链表的前一个节点
//         size = 0;       // 记录链表节点个数
//         endNode = new ListNode(-1);
//     }
//
//     public int get(int index) {
//         if (index < 0 || index >= size) {     // 索引越界 则返回-1
//             return -1;
//         }
//
//         if (index == size-1) {
//             // 若索引指向最后一个链表节点 则直接返回
//             return endNode.val;
//         }
//
//         // 索引不越界 则查询索引对应的 当前节点
//         ListNode cur = preNode;
//         for (int i = 0; i <= index; ++i) {
//             cur = cur.next;
//         }
//         return cur.val;
//     }
//     // 将一个值为val的节点插入到链表的第一个元素之前
//     // 且该节点称为新的链表的第一个节点
//     public void addAtHead(int val) {
//         ListNode newNode = new ListNode(val);
//         ++ size;    // 链表节点个数加一
//
//         if (size == 1) {
//             // 若此时增加的节点为第一个节点 则需要更新末端节点标记
//             endNode = newNode;
//         }
//
//         newNode.next = preNode.next;    // 新节点指向原有链表的头节点 成为新的头节点
//         preNode.next = newNode;         // 记录新的头节点
//     }
//     // 将一个值为val的节点追加到链表的末尾
//     public void addAtTail(int val) {
//         // addAtIndex(size, val);
//         // 追加到链表末尾 可直接通过表标记的末尾节点进行添加
//
//         if (size == 0) {
//             // 说明追加在链表末尾的节点为第一个节点
//             addAtHead(val);
//             return ;
//         }
//
//         ListNode newNode = new ListNode(val);
//         endNode.next = newNode;
//         endNode = newNode;
//         ++ size;    // 节点数增加
//     }
//
//     public void addAtIndex(int index, int val) {
//         if (index > size)
//             return ;   // 比链表长度大 则该节点不插入到链表中
//
//         if (index == size) {
//             // 索引为链表长度 则将节点插入链表末尾
//             addAtTail(val);
//             return ;
//         }
//
//         ListNode cur = preNode;
//         for (int i = 0; i < index; ++ i) {   // 获得待插入位置的前一个节点
//             cur = cur.next;
//         }
//         ListNode newNode = new ListNode(val);
//         newNode.next = cur.next;
//         cur.next = newNode;
//
//         ++  size;   // 链表个数加一
//     }
//
//     public void deleteAtIndex(int index) {
//         if (index >= size)
//             return ;  // 链表不含有节点或索引越界 删除无效
//
//         ListNode cur = preNode;
//         for (int i = 0; i < index; ++ i) {   // 寻找索引对应节点的前一个节点
//             cur = cur.next;
//         }
//
//         if (cur.next.next == null) {
//             // 说明此时删除节点为末尾节点 需要更新末尾节点
//             endNode = cur;
//         }
//         cur.next = cur.next.next;
//
//         -- size;        // 链表节点数减一
//     }
//
//     class ListNode {
//         int val;
//         ListNode next;
//
//         public ListNode() {
//         }
//         public ListNode(int val) {
//             this.val = val;
//             this.next = null;
//         }
//     }
// }

class MyLinkedList {

    int size;   // 记录节点个数
    ListNode preNode;   // 虚拟头节点
    ListNode tailNode;  // 虚拟尾节点

    public MyLinkedList() {     // 初始化双链表
        this.size = 0;
        preNode = new ListNode();
        tailNode = new ListNode();
        preNode.next = tailNode;
        tailNode.prev = preNode;
    }

    // 获取索引对应位置的 链表节点
    ListNode getByIndex(int index) {
        // 根据索引的位置 判断两边遍历时间
        ListNode cur;
        if (index < size/2) {   // 索引更靠近左边
            cur = preNode;
            for (int i = 0; i <= index; ++ i) {     // 寻找索引对应的节点
                cur = cur.next;
            }
        } else {     // 说明索引更靠近右边 使用虚拟尾节点查找更快
            cur = tailNode;
            for (int i = 0; i < size-index; ++i) {
                cur = cur.prev;
            }
        }
        return cur;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {   // 判断索引是否越界
            return -1;
        }
        ListNode cur = getByIndex(index);

        return cur.val;
    }
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return ;    // 索引越界 不添加到链表中
        }
        if (index < 0) index = 0;
        // 快速寻找索引对应节点
        ListNode cur = getByIndex(index);
        // 在索引对应节点前添加节点
        ListNode newNode = new ListNode(val);
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        newNode.next = cur;
        cur.prev = newNode;
        // 链表节点个数增加
        ++ size;
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {   // 数组越界
            return;
        }
        // 快速寻找索引对应节点
        ListNode cur = getByIndex(index);
        // 删除索引对应的节点
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        -- size;
    }

}
// 双链表节点
class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtpreNode(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}