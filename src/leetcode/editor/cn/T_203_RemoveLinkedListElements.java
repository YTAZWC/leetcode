package leetcode.editor.cn;


/**
 * 移除链表元素
 * @author 花木凋零成兰
 * @date 2023-12-05 22:42:03
 */
public class T_203_RemoveLinkedListElements {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_203_RemoveLinkedListElements().new Solution();
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
/*    public ListNode removeElements(ListNode head, int val) {
		if (head == null) 	// 链表为空时 直接返回空
			return null;
		ListNode p = new ListNode();
		p.next = head;		// 用新节点指向头节点 则在进行遍历检查时 可以检查到头节点
		ListNode nHead = p;	// 保存p节点
		while (p.next != null) {	// 保证p的下一个节点不为空
			if (p.next.val == val) {	// 若p节点的下一个节点的值为val 则删除
				p.next = p.next.next;	// 删除p节点的下一个节点
			} else {	// 若p节点的下一个节点值不为val 则继续遍历
				p = p.next;
			}
		}
		return nHead.next;	// nHead保存的是p节点 则应该返回其指向的下一个节点 才是新头节点
    }*/

/*	public ListNode removeElements(ListNode head, int val) {
		// 对头节点作特殊判断
		while (head != null && head.val == val)
			head = head.next;
		// 经过head判断后 head可能已经指向了空值 需要进行判断
		// 或链表原本就为 空 同样直接返回null
		if (head == null) 	// 链表为空时 直接返回空
			return null;
		// 排除头节点后 对其他节点进行判断 是否删除
		ListNode cur = head;	// 保留头节点head
		while (cur.next != null) {	// 注意此时cur不能为空
			if (cur.next.val == val)
				cur.next = cur.next.next;
			else
				cur = cur.next;
		}
		return head;
	}*/

	// 递归
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;	// 若当前节点为空 则直接返回null
		}
		head.next = removeElements(head.next, val);
		if (head.val == val) {	// 若当前节点需要被删除 则返回当前节点的下一个节点
			return head.next;
		} else {
			// 当前节点不需要被删除 则直接返回
			return head;
		}
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