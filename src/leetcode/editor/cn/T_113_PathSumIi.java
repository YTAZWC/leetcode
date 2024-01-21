package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113.路径总和 II
 * @author 花木凋零成兰
 * @date 2024-01-21 13:28:43
 */
public class T_113_PathSumIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_113_PathSumIi().new Solution();
	 
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
	List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		dfs(root, targetSum, new ArrayList<>());
		return ans;
    }
	private void dfs(TreeNode node, int targetSum, List<Integer> path) {
		if (node == null)
			return ;	// 边界条件
		path.add(node.val);		// 记录路径
		targetSum -= node.val;	// 更新目标值
		if (node.left == null && node.right == null && targetSum == 0) {
			ans.add(new ArrayList<>(path));	// 保存满足条件的路径
		}
		dfs(node.left, targetSum, path);
		dfs(node.right, targetSum, path);
		path.remove(path.size()-1);		// 回溯
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}