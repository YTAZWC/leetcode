package leetcode.editor.cn;


import utils.ListNode;

import java.util.HashMap;

/**
 * 链表相交
 * @author 花木凋零成兰
 * @date 2023-12-09 12:54:43
 */
class T_面试题_02_07_IntersectionOfTwoLinkedListsLcci {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_面试题_02_07_IntersectionOfTwoLinkedListsLcci().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;    // 若任意一个链表为空 则说明两个链表没有交点
        // 存储记录 headA 中的节点
        HashMap<ListNode, Integer> hashNode = new HashMap<>();
        ListNode curA = headA;
        while (curA != null) {
            // 将headA的节点保存到哈希表中
            hashNode.put(curA, 1);
            curA = curA.next;   // 继续遍历headA
        }
        // 判断两个链表是否相交
        ListNode curB = headB;
        while (curB != null) {
            if (hashNode.containsKey(curB)) {   // 若哈希表中存在节点
                return curB;    // 直接返回第一个相交的节点
            }
            curB = curB.next;   // 继续遍历headB
        }
        return null;
    }*/

    // 双指针
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null)
//            return null;    // 若任意一个链表为空 则说明两个链表没有交点
//        ListNode pA = headA;
//        ListNode pB = headB;
//        while (pA != pB) {  // 两个指针分别进行遍历 并判断
//            pA = pA==null? headB : pA.next;
//            pB = pB==null? headA : pB.next;
//        }
//        return pA;
//    }
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;    // 若任意一个链表为空 则说明两个链表没有交点

		int lenA = 0;	// 链表headA的长度
		int lenB = 0;	// 链表headB的长度
		ListNode curA = headA;
		ListNode curB = headB;
		// 统计headA的节点数
		while (curA != null) {
			++ lenA;
			curA = curA.next;
		}
		// 统计headB的节点数
		while (curB != null) {
			++ lenB;
			curB = curB.next;
		}
		// 重新初始化curA和curB
		curA = headA;
		curB = headB;
		// 保证两个链表中最长的链表为curA指向的链表
		if (lenA < lenB) {
			// 交换长度
			int t = lenB;
			lenB = lenA;
			lenA = t;
			// 交换指向的链表
			curA = headB;
			curB = headA;
		}
		int gap = lenA-lenB;	// 两个链表的长度差
		// 移动curA
		// 使得curA到链表末尾长度 与 curB到链表末尾长度 一致
		while (gap > 0) {
			-- gap;
			curA = curA.next;
		}
		// 同时遍历两个链表 并判断是否相等
		while (curA != null) {
			if (curA == curB) {
				return curA;
			}
			curA = curA.next;
			curB = curB.next;
		}
		return null;
	}


}
//leetcode submit region end(Prohibit modification and deletion)

}