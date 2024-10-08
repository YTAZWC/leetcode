package leetcode.editor.cn;


import utils.TreeNode;

import java.util.*;

/**
 * 103.二叉树的锯齿形层序遍历
 * @author 花木凋零成兰
 * @date 2024-10-08 16:18:29
 */
public class T_103_BinaryTreeZigzagLevelOrderTraversal {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
	 
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		// 标记遍历顺序 初始：从左往右
		boolean isFromLeft = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			LinkedList<Integer> level = new LinkedList<>();
			for (int i = 0; i < size; ++ i) {
				TreeNode node = queue.poll();
				if (isFromLeft) {
					level.addLast(node.val);
				} else {
					level.addFirst(node.val);
				}
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			isFromLeft = !isFromLeft;
			ans.add(level);
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}