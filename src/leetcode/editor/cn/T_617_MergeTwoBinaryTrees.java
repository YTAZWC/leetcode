package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 617.合并二叉树
 * @author 花木凋零成兰
 * @date 2024-02-05 07:54:59
 */
public class T_617_MergeTwoBinaryTrees {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_617_MergeTwoBinaryTrees().new Solution();
	 
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		return dfs(root1, root2);
    }
	private TreeNode dfs(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return null;	// 两节点为空时 直接返回null
		if (node1 == null)
			return node2;	// 此时第一棵树为空时 直接将第二棵树节点作为新二叉树节点
		if (node2 == null)
			return node1;	// 此时第二颗树为空时 直接将第一棵树节点作为新二叉树节点
		TreeNode node = new TreeNode();		// 两棵树均不为null时 构建新节点
		node.val = node1.val + node2.val;
		node.left = dfs(node1.left, node2.left);	// 构建左子树
		node.right = dfs(node1.right, node2.right);	// 构建右子树
		return node;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}