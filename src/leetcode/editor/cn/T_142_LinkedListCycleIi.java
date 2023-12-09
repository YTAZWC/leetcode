package leetcode.editor.cn;


import utils.ListNode;

import java.util.HashMap;

/**
 * 环形链表 II
 * @author 花木凋零成兰
 * @date 2023-12-09 15:37:48
 */
public class T_142_LinkedListCycleIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_142_LinkedListCycleIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
//    public ListNode detectCycle(ListNode head) {
//        // 创建哈希表
//		HashMap<ListNode, Integer> hashNode = new HashMap<>();
//		ListNode cur = head;
//		while (cur != null) {
//			if (hashNode.containsKey(cur)) {
//				return cur;
//			}
//			hashNode.put(cur, 1);
//			cur = cur.next;
//		}
//		return null;
//    }

	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		// 若fast为空则说明不含有环 退出循环
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {		// 当fast与slow相遇
				ListNode ptr = head;
				while (ptr != slow) {	// 寻找环入口处节点
					slow = slow.next;
					ptr = ptr.next;
				}
				return ptr;
			}
		}
		return null;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}