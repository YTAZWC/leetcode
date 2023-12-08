package leetcode.editor.cn;


/**
 * 两两交换链表中的节点
 * @author 花木凋零成兰
 * @date 2023-12-08 19:47:04
 */
public class T_24_SwapNodesInPairs {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_24_SwapNodesInPairs().new Solution();
	 
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
    /*public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			// 空链表或链表中只有一个节点 无需交换
			return head;
		}
		ListNode p = head;
		ListNode q = head.next;
		head = q;	// 此时头节点更新为原链表的第二节点
		ListNode pre = null;
		while (q != null) {
			// 进行节点交换
			p.next = q.next;
			q.next = p;
			// 将交换好的一组节点与 已交换好的链表链接
			if (pre != null)
				pre.next = q;
			// 更新交换好的新链表的尾节点
			pre = p;
			// 交换一组节点后 移动双指针
			p = p.next;
			if (p == null) // 若此时已移动到末尾则退出循环
				break;
			q = p.next;
		}
		return head;
    }*/
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			// 空链表或链表中只有一个节点 无需交换
			return head;
		}
		// 根据链表交换规律 交换后新链表的头节点为head.next
		ListNode newHead = head.next;	// 暂时先记录新链表的头节点
		swapListNode(head, head.next, null);

		return newHead;	// 交换完成后 返回新链表
	}

	private void swapListNode(ListNode p, ListNode q, ListNode pre) {
		if (q == null) return ;
		// 进行交换
		p.next = q.next;
		q.next = p;
		// 进行链接
		if (pre != null)
			pre.next = q;
		// 继续交换
		if (p.next == null) return ;
		swapListNode(p.next, p.next.next, p);
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