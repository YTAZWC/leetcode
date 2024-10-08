package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102.二叉树的层序遍历
 * @author 花木凋零成兰
 * @date 2023-12-31 19:14:12
 */
public class T_102_BinaryTreeLevelOrderTraversal {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_102_BinaryTreeLevelOrderTraversal().new Solution();
	 
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
//    public List<List<Integer>> levelOrder(TreeNode root) {
//		List<List<Integer>> ans = new ArrayList<>();
//		if (root == null)	// 边界条件
//			return ans;
//		Queue<TreeNode> queue = new ArrayDeque<>();	// 辅助队列
//		queue.offer(root);	// 将第一层入队
//		while (!queue.isEmpty()) {
//			int size = queue.size();	// 获取该层的节点数
//			List<Integer> level = new ArrayList<>();	// 保存该层的节点值
//			for (int i = 0; i < size; ++ i) {	// 对每层结点进行遍历 以及获取下一层
//				TreeNode node = queue.poll();
//				level.add(node.val);
//				if (node.left != null)
//					queue.offer(node.left);
//				if (node.right != null)
//					queue.offer(node.right);
//			}
//			ans.add(level);	// 保存 每层的结点的遍历结果
//		}
//		return ans;
//    }
	// 递归
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		bfs(root, 0, ans);
		return ans;
	}
	private void bfs(TreeNode node, int deeply, List<List<Integer>> ans) {
		if (node == null)	// 已经遍历到最后一层结束
			return ;
		if (deeply >= ans.size()) {	// 出现新层
			List<Integer> level = new ArrayList<>();
			level.add(node.val);
			ans.add(level);
		} else {	// 该结点在已经建立的层中
			ans.get(deeply).add(node.val);
		}
		bfs(node.left, deeply+1, ans);	// 继续向左遍历
		bfs(node.right, deeply+1, ans);	// 继续向右遍历
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}