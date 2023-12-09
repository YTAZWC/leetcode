package leetcode.editor.cn;


/**
 * 删除链表的倒数第 N 个结点
 * @author 花木凋零成兰
 * @date 2023-12-08 21:10:52
 */
public class T_19_RemoveNthNodeFromEndOfList {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_19_RemoveNthNodeFromEndOfList().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
/*    public ListNode removeNthFromEnd(ListNode head, int n) {
		int count = 0;
		ListNode p = head;
		while (p != null) {
			++ count;
			p = p.next;
		}
		if (count == 1) {
			return null;	// 只有一个节点 删除后链表为空
		}

		int index = count - n;		// 获得待删除节点位置索引 且索引从0开始计算
		ListNode pre = new ListNode(-1);	// 虚拟头节点
		pre.next = head;
		ListNode cur = pre;
		for (int i = 0; i < index; ++i) {
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return pre.next;
    }*/

	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 定义一个虚拟头节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = dummy;
		for (int i = 0; i < n; ++i) {
			p = p.next;
		}
		ListNode q = dummy;
		while (p.next != null) {
			p = p.next;
			q = q.next;
		}
		q.next = q.next.next;
		return dummy.next;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}