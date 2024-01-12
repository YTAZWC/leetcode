package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 110.平衡二叉树
 * @author 花木凋零成兰
 * @date 2024-01-12 20:19:02
 */
public class T_110_BalancedBinaryTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_110_BalancedBinaryTree().new Solution();
	 
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
//    public boolean isBalanced(TreeNode root) {
//		if (root == null) return true;
//		// 后序遍历 先遍历获取左右子树高度
//		int leftHeight = getHeight(root.left);
//		int rightHeight = getHeight(root.right);
//		return Math.abs(leftHeight - rightHeight) <= 1
//				&& isBalanced(root.left) && isBalanced(root.right);
//    }
//	// 后序遍历获取 二叉树高度
//	private int getHeight(TreeNode node) {
//		if (node == null)
//			return 0;
//		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
//	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		return getHeight(root) >= 0;
	}
	// 后序遍历获取 二叉树高度
	private int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		// 左
		int leftHeight = getHeight(node.left);
		// 右
		int rightHeight = getHeight(node.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight) > 1)
			return -1;	// 若左子树或右子树或当前子树不平衡 则返回-1
		// 若当前子树平衡 则返回其高度
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}