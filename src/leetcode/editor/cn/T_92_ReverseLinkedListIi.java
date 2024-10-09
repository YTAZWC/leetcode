package leetcode.editor.cn;


import utils.ListNode;

/**
 * 92.反转链表 II
 * @author 花木凋零成兰
 * @date 2024-10-09 21:36:08
 */
public class T_92_ReverseLinkedListIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_92_ReverseLinkedListIi().new Solution();
	 
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
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//		// 创建虚拟头节点   避免特殊情况需要特殊处理
//		ListNode dummy = new ListNode(-1);
//		dummy.next = head;
//		ListNode leftPre = dummy;   // 获取反转链表左节点的前一个节点
//		for (int i = 0; i < left-1; ++ i) {
//			leftPre = leftPre.next;
//		}
//		// 记录反转链表的左起始节点 - 反转链表后的尾节点
//		ListNode leftHead = leftPre.next;
//		// 记录反转链表的右终止节点 - 反转链表后的首节点
//		ListNode rightTail = leftPre;
//		for (int i = 0; i < right-left+1; ++ i) {
//			rightTail = rightTail.next;
//		}
//		// 记录反转链表后 链表尾节点应该继续链表的节点
//		ListNode tailRight = rightTail.next;
//		// 截断需要反转的链表段进行反转
//		leftPre.next = null;
//		rightTail.next = null;
//		// 执行反转
//		ListNode pre = null;
//		ListNode cur = leftHead;
//		while (cur != null) {
//			ListNode t = cur.next;
//			cur.next = pre;
//			pre = cur;
//			cur = t;
//		}
//		// 反转后进行链接
//		leftHead.next = tailRight;
//		leftPre.next = rightTail;
//		return dummy.next;
//    }
public ListNode reverseBetween(ListNode head, int left, int right) {
	// 创建虚拟头节点   避免特殊情况需要特殊处理
	ListNode dummy = new ListNode(-1);
	dummy.next = head;
	ListNode leftPre = dummy;   // 获取反转链表左节点的前一个节点
	for (int i = 0; i < left-1; ++ i) {
		leftPre = leftPre.next;
	}
	// 反转链表
	// 每次反转链表结束后: pre指向新链表头节点, cur指向反转链表的下一个节点
	ListNode pre = null;
	ListNode cur = leftPre.next;
	for (int i = 0; i < right-left+1; ++ i) {
		ListNode next = cur.next;
		cur.next = pre;
		pre = cur;
		cur = next;
	}
	leftPre.next.next = cur;
	leftPre.next = pre;
	return dummy.next;
}
}
//leetcode submit region end(Prohibit modification and deletion)

}