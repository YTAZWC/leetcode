package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 112.路径总和
 * @author 花木凋零成兰
 * @date 2024-01-21 11:01:19
 */
public class T_112_PathSum {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_112_PathSum().new Solution();
	 
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;	// 边界条件
		targetSum -= root.val;
		if (root.left == null && root.right == null) {	// 当该节点为叶子节点时
			return targetSum == 0;	// 判断路径上节点值的和是否等于targetSum
		}
		return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}