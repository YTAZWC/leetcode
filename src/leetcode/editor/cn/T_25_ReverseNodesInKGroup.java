package leetcode.editor.cn;


/**
 * 25.K 个一组翻转链表
 * @author 花木凋零成兰
 * @date 2024-10-05 22:57:12
 */
public class T_25_ReverseNodesInKGroup {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_25_ReverseNodesInKGroup().new Solution();
		 ListNode head = new T_25_ReverseNodesInKGroup.ListNode(1);
		 ListNode head1 = new T_25_ReverseNodesInKGroup.ListNode(2);
		 ListNode head2 = new T_25_ReverseNodesInKGroup.ListNode(3);
		 ListNode head3 = new T_25_ReverseNodesInKGroup.ListNode(4);
		 ListNode head4 = new T_25_ReverseNodesInKGroup.ListNode(5);
		 head.next = head1;
		 head1.next = head2;
		 head2.next = head3;
		 head3.next = head4;
		 solution.reverseKGroup(head, 2);
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
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		ListNode p = head;
		int len = 1;
		// 遍历获得一组链表
		while (p != null && p.next != null && len < k) {
			++ len;
			p = p.next;
		}
		if (len < k) {
			// 剩余链表不足为一组 不进行反转
			return head;
		}
		// 执行反转
		ListNode pre = null;
		ListNode q = head;
		ListNode nextStart = p.next;
		while (q != p.next) {
			ListNode t = q.next;
			q.next = pre;
			pre = q;
			q = t;
		}
		// 此时head为新的末尾节点
		// 继续反转下一组 并链接到上一组的末尾节点
		head.next = reverseKGroup(nextStart, k);
		return pre;
	}

}
//leetcode submit region end(Prohibit modification and deletion)
static class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

}