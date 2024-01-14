package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257.二叉树的所有路径
 * @author 花木凋零成兰
 * @date 2024-01-14 10:46:36
 */
public class T_257_BinaryTreePaths {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_257_BinaryTreePaths().new Solution();
	 
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
	List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
		dfs(new StringBuffer(), root);
		return ans;
    }
	private void dfs(StringBuffer result, TreeNode node) {
		if (node == null)
			return ;
		int size = result.length();	// 记录进入函数时的长度 便于递归回溯
		result.append(node.val);	// 路径增加
		if (node.left == null && node.right == null) {
			// 遍历到叶子节点 保存路径
			ans.add(result.toString());
			result.delete(size, result.length());	// 回溯
			return ;
		}
		result.append("->");
		dfs(result, node.left);	// 向左往深处遍历
		dfs(result, node.right);	// 向右往深处遍历
		result.delete(size, result.length());	// 回溯
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}