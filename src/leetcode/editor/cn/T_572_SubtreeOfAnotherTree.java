package leetcode.editor.cn;


import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 572.另一棵树的子树
 * @author 花木凋零成兰
 * @date 2024-01-05 13:42:40
 */
public class T_572_SubtreeOfAnotherTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_572_SubtreeOfAnotherTree().new Solution();
	 
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		// 使用统一迭代进行二叉树遍历
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.val == subRoot.val) {	// 若出现与subRoot的根节点值相等 则进一步判断是否为子树
				if (isSameTree(node, subRoot))
					return true;	// 为子树 则直接返回true
			}
			if (node.right != null) stack.push(node.right);
			if (node.left != null) stack.push(node.left);
		}
		return false;
    }
	// 判断两棵树是否相等
	private boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}