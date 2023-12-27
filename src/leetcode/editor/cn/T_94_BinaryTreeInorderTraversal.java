package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94.二叉树的中序遍历
 * @author 花木凋零成兰
 * @date 2023-12-27 14:45:35
 */
public class T_94_BinaryTreeInorderTraversal {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_94_BinaryTreeInorderTraversal().new Solution();
	 
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
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		inorder(root, ans);
		return ans;
    }
	private void inorder(TreeNode node, List<Integer> ans) {
		if (node == null)
			return ;
		inorder(node.left, ans);
		ans.add(node.val);
		inorder(node.right, ans);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}