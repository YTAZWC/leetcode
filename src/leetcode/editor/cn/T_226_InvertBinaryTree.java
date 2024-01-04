package leetcode.editor.cn;


import com.sun.source.tree.Tree;
import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 226.翻转二叉树
 * @author 花木凋零成兰
 * @date 2024-01-04 10:41:03
 */
public class T_226_InvertBinaryTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_226_InvertBinaryTree().new Solution();
	 
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
//    public TreeNode invertTree(TreeNode root) {
//		if (root != null) {
//			Queue<TreeNode> queue = new ArrayDeque<>();
//			queue.offer(root);
//			while (!queue.isEmpty()) {
//				int size = queue.size();
//				for (int i = 0; i < size; ++ i) {
//					TreeNode node = queue.poll();
//					// 进行左右节点交换
//					TreeNode temp = node.left;
//					node.left = node.right;
//					node.right = temp;
//					if (node.left != null) queue.offer(node.left);
//					if (node.right != null) queue.offer(node.right);
//				}
//			}
//		}
//		return root;
//    }

	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			root = doInvertTree(root);
		}
		return root;
	}
	private TreeNode doInvertTree(TreeNode node) {
		if (node == null)
			return null;
		TreeNode temp = node.left;
		node.left = doInvertTree(node.right);
		node.right = doInvertTree(temp);
		return node;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}