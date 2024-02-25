package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 669.修剪二叉搜索树
 * @author 花木凋零成兰
 * @date 2024-02-25 21:52:34
 */
public class T_669_TrimABinarySearchTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_669_TrimABinarySearchTree().new Solution();
	 
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null)
			return null;	// 边界条件
		// 先对中间节点进行判断
		if (root.val < low)	// 说明该节点及左子树均需移除
			return trimBST(root.right, low, high);	// 只需继续修剪右子树
		if (root.val > high)	// 说明该节点及右子树均需移除
			return trimBST(root.left, low, high);	// 只需继续修剪左子树
		// 当中间节点符合要求后 只需修剪其左右子树
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;	// 将修剪后的二叉搜索树返回
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}