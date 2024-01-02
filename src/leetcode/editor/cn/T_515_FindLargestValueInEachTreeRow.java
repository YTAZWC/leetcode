package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 515.在每个树行中找最大值
 * @author 花木凋零成兰
 * @date 2024-01-02 19:02:52
 */
public class T_515_FindLargestValueInEachTreeRow {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_515_FindLargestValueInEachTreeRow().new Solution();
	 
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
//    public List<Integer> largestValues(TreeNode root) {
//		List<Integer> ans = new ArrayList<>();
//		if (root == null)
//			return ans;		// 排除边界条件
//		Queue<TreeNode> queue = new ArrayDeque<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			int max = Integer.MIN_VALUE;	// 标记该层最大值
//			for (int i = 0; i < size; ++ i) {
//				TreeNode node = queue.poll();
//				max = Math.max(max, node.val);
//				if (node.left != null) queue.offer(node.left);
//				if (node.right != null) queue.offer(node.right);
//			}
//			ans.add(max);	// 记录保存每层最大值
//		}
//		return ans;
//    }

	// 递归+dfs
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		dfs(root, 0, ans);
		return ans;
	}
	private void dfs(TreeNode node, int deeply, List<Integer> ans) {
		if (node == null)
			return ;	// 递归边界
		if (deeply >= ans.size()) {	// 该层未曾出现过
			ans.add(node.val);
		} else {	// 若该层出现过 比较得出更大值
			Integer num = ans.get(deeply);
			if (num < node.val) {
				ans.set(deeply, node.val);
			}
		}
		dfs(node.left, deeply+1, ans);
		dfs(node.right, deeply+1, ans);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}