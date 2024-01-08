package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 111.二叉树的最小深度
 * @author 花木凋零成兰
 * @date 2024-01-03 13:08:12
 */
public class T_111_MinimumDepthOfBinaryTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_111_MinimumDepthOfBinaryTree().new Solution();
	 
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
//    public int minDepth(TreeNode root) {
//		int ans = 0;
//		if (root == null)
//			return ans;
//		Queue<TreeNode> queue = new ArrayDeque<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			++ ans;	// 记录距离
//			for (int i = 0; i < size; ++ i) {
//				TreeNode node = queue.poll();
//				if (node.left == null && node.right == null) {
//					// 找到最近的叶子节点
//					return ans;
//				}
//				if (node.left != null) queue.offer(node.left);
//				if (node.right != null) queue.offer(node.right);
//			}
//		}
//		return ans;
//    }

//	int ans = Integer.MAX_VALUE;
//	public int minDepth(TreeNode root) {
//		getMinDepth(root, 1);
//		if (ans == Integer.MAX_VALUE) return 0;
//		return ans;
//	}
//	private void getMinDepth(TreeNode node, int depth) {
//		if (node == null)
//			return ;	// 结束遍历
//		if (node.left == null && node.right == null) {
//			ans = Math.min(depth, ans);		// 记录最小深度
//			return ;
//		}
//		getMinDepth(node.left, depth+1);
//		getMinDepth(node.right, depth+1);
//	}

	public int minDepth(TreeNode root) {
		return getHeight(root);
	}
	// 后序遍历递归求二叉树节点高度
	private int getHeight(TreeNode node) {
		if (node == null)
			return 0;	// 边界条件 空节点返回0
		// 左
		int leftHeight = getHeight(node.left);
		// 右
		int rightHeight = getHeight(node.right);
		// 获取中 高度
		int height;
		if (node.left != null && node.right == null)
			height = leftHeight+1;
		else if (node.left == null && node.right != null)
			height = rightHeight+1;
		else height = Math.min(leftHeight, rightHeight)+1;
		return height;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}