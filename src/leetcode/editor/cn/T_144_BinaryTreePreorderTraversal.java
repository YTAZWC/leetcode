package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144.二叉树的前序遍历
 * @author 花木凋零成兰
 * @date 2023-12-27 13:52:00
 */
public class T_144_BinaryTreePreorderTraversal {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_144_BinaryTreePreorderTraversal().new Solution();
	 
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
//    public List<Integer> preorderTraversal(TreeNode root) {
//		List<Integer> ans = new ArrayList<>();
//		preorderTraversal(root, ans);
//		return ans;
//    }
//	private void preorderTraversal(TreeNode node, List<Integer> ans) {
//		if (node == null)
//			return ;	// 递归终止条件
//		// 递归过程
//		ans.add(node.val);	// 先遍历父节点
//		preorderTraversal(node.left, ans);	// 再遍历左子节点
//		preorderTraversal(node.right, ans);	// 最后遍历右子节点
//	}

//	public List<Integer> preorderTraversal(TreeNode root) {
//		List<Integer> ans = new ArrayList<>();
//
//		if (root == null)	// 边界条件
//			return ans;
//
//		Deque<TreeNode> stack = new LinkedList<>();	// 用于存储二叉树的节点
//		stack.push(root);
//		while (!stack.isEmpty()) {
//			// 前序遍历先遍历 中
//			TreeNode node = stack.pop();
//			ans.add(node.val);
//			// 根据栈后进先出 先保存右节点
//			if (node.right != null)
//				stack.push(node.right);
//			// 再保存左节点
//			if (node.left != null)
//				stack.push(node.left);
//		}
//		return ans;
//	}

	// 统一迭代法 前序
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null)	// 边界条件
			return ans;
		Deque<TreeNode> stack = new LinkedList<>();	// 用于存储二叉树的节点
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				// 前序遍历 先保存右节点
				if (node.right != null)
					stack.push(node.right);
				// 再保存左节点
				if (node.left != null)
					stack.push(node.left);
				// 最后 中节点入栈
				stack.push(node);
				stack.push(null);	// 空指针进行标记
			} else {
				node = stack.pop();
				ans.add(node.val);
			}
		}
		return ans;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}