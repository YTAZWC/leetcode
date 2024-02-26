package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 538.把二叉搜索树转换为累加树
 * @author 花木凋零成兰
 * @date 2024-02-26 15:07:51
 */
public class T_538_ConvertBstToGreaterTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_538_ConvertBstToGreaterTree().new Solution();
	 
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
	int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
		dfs(root);
		return root;
    }
	private void dfs(TreeNode node) {
		if (node == null)
			return ;	// 边界条件
		dfs(node.right);	// 先往右遍历
		node.val += preSum;	// 更新节点的值
		preSum = node.val;	// 更新记录的右端节点和
		dfs(node.left);		// 最后更改左子树
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}