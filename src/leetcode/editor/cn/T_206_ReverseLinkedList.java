package leetcode.editor.cn;


/**
 * 反转链表
 * @author 花木凋零成兰
 * @date 2023-12-06 21:38:20
 */
public class T_206_ReverseLinkedList {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_206_ReverseLinkedList().new Solution();
	 
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
//    public ListNode reverseList(ListNode head) {
//		if (head == null)	// head为空 直接返回
//			return null;
//		// p为q的前一个节点
//		ListNode p = head;
//		ListNode q = head.next;
//		while (q != null) {
//			ListNode t = q.next;	// 记录下q的下一个节点
//			q.next = p;		// 改变节点的指向 将其反转指向前一个节点
//			p = q;			// 重新移动p为 未反转节点的前一个节点
//			q = t;			// 移动q到还未反转的节点
//		}
//		head.next = null;	// 第一个节点的指向需要改为空
//		return p;		// 返回新的头节点 即原链表的尾节点
//    }
	// 递归
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)	// head为空 直接返回
			return head;
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
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