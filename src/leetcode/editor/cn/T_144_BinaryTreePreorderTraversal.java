package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144.二叉树的前序遍历
 * @author 花木凋零成兰
 * @date 2023-12-27 13:52:00
 */
public class T_144_BinaryTreePreorderTraversal {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_144_BinaryTreePreorderTraversal().new Solution();
	 
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
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		preorderTraversal(root, ans);
		return ans;
    }
	private void preorderTraversal(TreeNode node, List<Integer> ans) {
		if (node == null)
			return ;	// 递归终止条件
		// 递归过程
		ans.add(node.val);	// 先遍历父节点
		preorderTraversal(node.left, ans);	// 再遍历左子节点
		preorderTraversal(node.right, ans);	// 最后遍历右子节点
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}