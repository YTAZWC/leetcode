package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 98.验证二叉搜索树
 * @author 花木凋零成兰
 * @date 2024-02-05 15:23:00
 */
public class T_98_ValidateBinarySearchTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_98_ValidateBinarySearchTree().new Solution();
	 
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
//    public boolean isValidBST(TreeNode root) {
//		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//	private boolean isValidBST(TreeNode node, long minVal, long maxVal) {
//		if (node == null)
//			return true;
//		if (node.val <= minVal || node.val >= maxVal)
//			return false;	// 该节点值 不满足二叉搜索树的范围 返回false
//		return isValidBST(node.left, minVal, node.val) && isValidBST(node.right, node.val, maxVal);
//	}

	// 中序遍历
	TreeNode pre = null;	// 标记中序遍历顺序当前节点的前一个节点
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		boolean left = isValidBST(root.left);	// 中序遍历先 遍历判断左子树
		if (pre != null && pre.val >= root.val)		// 再判断中
			return false;	// 不符合条件
		pre = root;	// 更新指针
		boolean right = isValidBST(root.right);	// 中序遍历 遍历判断右子树
		return left && right;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}