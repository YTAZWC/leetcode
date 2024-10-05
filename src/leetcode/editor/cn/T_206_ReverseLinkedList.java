package leetcode.editor.cn;


/**
 * 206.反转链表
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
//		if (head == null) {
//			return null;
//		}
//		ListNode p = null;
//		ListNode q = head;
//		while (q != null) {
//			// 记录下一个反转的节点
//			ListNode temp = q.next;
//			// 改变节点指向 反转指向前一个节点
//			q.next = p;
//			// 重新移动p为 新链表头节点
//			p = q;
//			q = temp;	// 移动q继续反转
//		}
//		return p;
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