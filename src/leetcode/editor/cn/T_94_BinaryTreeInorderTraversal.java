package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94.二叉树的中序遍历
 * @author 花木凋零成兰
 * @date 2023-12-27 14:45:35
 */
public class T_94_BinaryTreeInorderTraversal {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_94_BinaryTreeInorderTraversal().new Solution();
	 
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
//    public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> ans = new ArrayList<>();
//		inorder(root, ans);
//		return ans;
//    }
//	private void inorder(TreeNode node, List<Integer> ans) {
//		if (node == null)
//			return ;
//		inorder(node.left, ans);
//		ans.add(node.val);
//		inorder(node.right, ans);
//	}

//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> ans = new ArrayList<>();
//		if (root == null)	// 边界条件
//			return ans;
//		Deque<TreeNode> stack = new LinkedList<>();
//		stack.push(root);
//		while (!stack.isEmpty()) {
//			while (stack.peek().left != null)	// 一直往左 直到第一个应该遍历的左节点
//				stack.push(stack.peek().left);
//			TreeNode node = stack.pop();	// 弹出应该遍历的节点
//			if(!stack.isEmpty())	// 切点该节点 与栈中可能是父节点的联系
//				stack.peek().left = null;
//			ans.add(node.val);	// 遍历
//			if (node.right != null) // 若存在右节点 则开始遍历
//				stack.push(node.right);
//		}
//		return ans;
//	}
	// 另一种迭代写法
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null)	// 边界条件
			return ans;
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {	// 如果该节点不为空 则让其一直往左
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();	// 此时处理栈弹出的元素
				ans.add(cur.val);
				cur = cur.right;
			}
		}
		return ans;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}