package leetcode.editor.cn;


import utils.TreeNode;

import java.util.*;

/**
 * 145.二叉树的后序遍历
 * @author 花木凋零成兰
 * @date 2023-12-27 14:21:10
 */
public class T_145_BinaryTreePostorderTraversal {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_145_BinaryTreePostorderTraversal().new Solution();
	 
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
//    public List<Integer> postorderTraversal(TreeNode root) {
//		List<Integer> ans = new ArrayList<>();
//		postorder(root, ans);
//		return ans;
//    }
//
//	private void postorder(TreeNode node, List<Integer> ans) {
//		if (node == null)
//			return;
//		postorder(node.left, ans);
//		postorder(node.right, ans);
//		ans.add(node.val);
//	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			ans.add(node.val);
			if (node.left != null) stack.push(node.left);
			if (node.right != null) stack.push(node.right);
		}
		Collections.reverse(ans);
		return ans;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}