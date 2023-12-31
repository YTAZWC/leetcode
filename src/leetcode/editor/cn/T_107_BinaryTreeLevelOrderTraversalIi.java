package leetcode.editor.cn;


import utils.TreeNode;

import java.util.*;

/**
 * 107.二叉树的层序遍历 II
 * @author 花木凋零成兰
 * @date 2023-12-31 20:11:44
 */
public class T_107_BinaryTreeLevelOrderTraversalIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_107_BinaryTreeLevelOrderTraversalIi().new Solution();
	 
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
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//		List<List<Integer>> ans = new LinkedList<>();	// 链表从头结点插入花费时间更低
//		if (root == null)
//			return ans;		// 边界情况
//		Queue<TreeNode> queue = new ArrayDeque<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			List<Integer> level = new ArrayList<>();	// 数组型花费更小
//			for (int i = 0; i < size; ++ i) {
//				TreeNode node = queue.poll();
//				level.add(node.val);
//				if (node.left != null) queue.offer(node.left);
//				if (node.right != null) queue.offer(node.right);
//			}
//			ans.add(0, level);	// 每次插入每层结点 从头插入
//		}
//		return ans;
//    }

	// 递归
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<>();	// 链表从头结点插入花费时间更低
		BFS(root, 0, ans);
		Collections.reverse(ans);	// 进行反转
		return ans;
	}

	private void BFS(TreeNode node, int deeply, List<List<Integer>> ans) {
		if (node == null)
			return ;
		if (deeply >= ans.size()) {
			List<Integer> level = new ArrayList<>();
			level.add(node.val);
			ans.add(level);
		} else {
			ans.get(deeply).add(node.val);
		}
		BFS(node.left, deeply + 1, ans);
		BFS(node.right, deeply + 1, ans);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}