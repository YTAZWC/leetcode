package leetcode.editor.cn;


import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 100.相同的树
 * @author 花木凋零成兰
 * @date 2024-01-05 12:37:57
 */
public class T_100_SameTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_100_SameTree().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//
//		if (p == null && q == null)
//			return true;
//		if (p == null || q == null)
//			return false;
//		return p.val == q.val
//				&& isSameTree(p.left, q.left)
//				&& isSameTree(p.right, q.right);
//    }

	public boolean isSameTree(TreeNode p, TreeNode q) {
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offerFirst(p);
		deque.offerLast(q);
		while (!deque.isEmpty()) {
			TreeNode left = deque.pollFirst();
			TreeNode right = deque.pollLast();
			if (left == null && right == null) continue;
			if (left == null || right == null) return false;
			if (left.val != right.val) return false;

			// 两者采用一样的遍历顺序 中左右 所以 右指针先进栈 再左指针进栈
			deque.offerFirst(left.right);
			deque.offerFirst(left.left);
			deque.offerLast(right.right);
			deque.offerLast(right.left);
		}
		return true;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}