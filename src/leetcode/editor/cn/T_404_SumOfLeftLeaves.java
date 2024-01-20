package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 404.左叶子之和
 * @author 花木凋零成兰
 * @date 2024-01-20 19:57:41
 */
public class T_404_SumOfLeftLeaves {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_404_SumOfLeftLeaves().new Solution();
	 
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
    private int ans = 0;
	public int sumOfLeftLeaves(TreeNode root) {
		pre(root);
		return ans;
    }
	private void pre(TreeNode node) {
		if (node == null)
			return ;	// 考虑边界条件
		if (node.left != null && node.left.left == null && node.left.right == null) {
			// 若左子节点不为空 且左子节点为叶子节点
			ans += node.left.val;	// 对左叶子求和
		}
		pre(node.left);		// 遍历 左
		pre(node.right);	// 遍历 右
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}