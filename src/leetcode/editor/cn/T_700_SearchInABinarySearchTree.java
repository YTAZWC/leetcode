package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 700.二叉搜索树中的搜索
 * @author 花木凋零成兰
 * @date 2024-02-05 11:49:02
 */
public class T_700_SearchInABinarySearchTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_700_SearchInABinarySearchTree().new Solution();
	 
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
	TreeNode ans;	// 保存搜索中 所找到的子树
    public TreeNode searchBST(TreeNode root, int val) {
		ans = null;	// 初始搜索结果为 null
		dfs(root, val);
		return ans;
    }
	private void dfs(TreeNode node, int val) {
		if (node == null)
			return ;
		if (node.val == val) {
			ans = node;
			return ;	// 若找到子树 则终止搜索
		}
		dfs(node.left, val);	// 向左寻找
		dfs(node.right, val);	// 向右寻找
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}