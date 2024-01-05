package leetcode.editor.cn;


import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101.对称二叉树
 * @author 花木凋零成兰
 * @date 2024-01-05 09:08:04
 */
public class T_101_SymmetricTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_101_SymmetricTree().new Solution();
	 
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
//    public boolean isSymmetric(TreeNode root) {
//		// 注意题目条件 root != null
//		return doIsSymmetric(root.left, root.right);
//    }
//	private boolean doIsSymmetric(TreeNode left, TreeNode right) {
//		if (left == null && right != null)
//			return false;
//		if (left != null && right == null)
//			return false;
//		if (left == null && right == null)
//			return true;
//		// 相等比较 节点值		然后接着判断其余节点
//		return left.val == right.val && doIsSymmetric(left.left, right.right) && doIsSymmetric(left.right, right.left);
//	}

	public boolean isSymmetric(TreeNode root) {
		// 注意题目条件 root != null
		if  (root.left == null && root .right != null)
			return false;	// 边界
		if (root.left == null && root.right == null)
			return true;	// 边界特殊情况
		if (root.left != null && root.right == null)
			return false;
		Deque<TreeNode> leftSt = new LinkedList<>();	// 对左子树按 中左右 进行遍历
		Deque<TreeNode> rightSt = new LinkedList<>();	// 对右子树按 中右左 进行遍历
		leftSt.push(root.left);		// 左子树第一个节点进栈
		rightSt.push(root.right);	// 右子树第一个节点进栈
		while (!leftSt.isEmpty() && !rightSt.isEmpty()) {
			TreeNode left = leftSt.pop();
			TreeNode right = rightSt.pop();
			if (left == null && right == null)
				continue;
			if (left == null && right != null)
				return false;
			if (left != null && right == null)
				return false;
			if (left.val != right.val)
				return false;
			// 左子树 先进右节点 再进左节点
			leftSt.push(left.right);
			leftSt.push(left.left);
			// 右子树 先进左节点 再进右节点
			rightSt.push(right.left);
			rightSt.push(right.right);
		}
		// 左右遍历栈 均为空 则说明对每个节点均完成对比
		return leftSt.isEmpty() && rightSt.isEmpty();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}