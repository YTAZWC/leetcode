package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 104.二叉树的最大深度
 * @author 花木凋零成兰
 * @date 2024-01-03 12:18:48
 */
public class T_104_MaximumDepthOfBinaryTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_104_MaximumDepthOfBinaryTree().new Solution();
	 
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
//    public int maxDepth(TreeNode root) {
//		int ans = 0;
//		if (root == null)
//			return ans;		// 边界条件
//		Queue<TreeNode> queue = new ArrayDeque<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			++ ans;		// 记录层数
//			for (int i = 0; i < size; ++ i) {
//				TreeNode node = queue.poll();
//				if (node.left != null) queue.offer(node.left);
//				if (node.right != null) queue.offer(node.right);
//			}
//		}
//		return ans;
//    }

	int ans = 0;
	public int maxDepth(TreeNode root) {
		getMaxDepth(root, 1);
		return ans;
	}
	private void getMaxDepth(TreeNode node, int depth) {
		if (node == null)
			return ;
		ans = Math.max(ans, depth);
		getMaxDepth(node.left, depth+1);
		getMaxDepth(node.right, depth+1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}