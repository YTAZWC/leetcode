package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 530.二叉搜索树的最小绝对差
 * @author 花木凋零成兰
 * @date 2024-02-06 13:12:29
 */
public class T_530_MinimumAbsoluteDifferenceInBst {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_530_MinimumAbsoluteDifferenceInBst().new Solution();
	 
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
	private int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
		getMinimumDifference(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return ans;
    }
	private void getMinimumDifference(TreeNode node, long minVal, long maxVal) {
		if (node == null)
			return ;	// 边界条件
		// 计算并更新最小差值
		ans = Math.min(ans, (int)Math.min(node.val-minVal, maxVal-node.val)); // 中间节点计算过程
		getMinimumDifference(node.left, minVal, node.val);	// 遍历左子树
		getMinimumDifference(node.right, node.val, maxVal);	// 遍历右子树
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}