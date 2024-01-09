package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 222.完全二叉树的节点个数
 * @author 花木凋零成兰
 * @date 2024-01-09 13:14:49
 */
public class T_222_CountCompleteTreeNodes {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_222_CountCompleteTreeNodes().new Solution();
	 
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
//    public int countNodes(TreeNode root) {
//		int ans = 0;
//		if (root == null)
//			return ans;		// 边界条件
//		Deque<TreeNode> stack = new LinkedList<>();
//		stack.push(root);
//		while (!stack.isEmpty()) {
//			TreeNode node = stack.pop();
//			if (node != null) {
//				// 对节点进行处理 添加待遍历节点
//				if (node.right != null)
//					stack.push(node.right);
//				if (node.left != null)
//					stack.push(node.left);
//				// 添加待处理节点
//				stack.push(node);
//				stack.push(null);	// 使用null标记待处理节点
//			} else {
//				stack.pop();	// 弹出待处理节点
//				++ ans;		// 对节点进行计数
//			}
//		}
//		return ans;
//    }

	// BFS
//	public int countNodes(TreeNode root) {
//		int ans = 0;
//		if (root == null)
//			return ans;		// 边界条件
//		Queue<TreeNode> queue = new ArrayDeque<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			for (int i = 0; i < size; ++i) {
//				++ ans;
//				TreeNode node = queue.poll();
//				if (node.left != null) queue.offer(node.left);
//				if (node.right != null) queue.offer(node.right);
//			}
//		}
//		return ans;
//	}

	// 二分查找 + 位运算
	public int countNodes(TreeNode root) {
		if (root == null) return 0;	// 边界
		// 获取二叉树的层数
		int h = 0;
		TreeNode node = root;
		while (node.left != null) {
			++ h;	// 计算二叉树的层数
			node = node.left;
		}
		// 根据二叉树的层数 获取节点数范围
		int min = 1 << h;	// 位运算计算	最低限度
		int max = (1 << (h + 1)) - 1;	// 位运算计算 最高限度
		int ans = 0;	// 即二分查找寻找符合条件的 用ans来保存
		// 二分查找区间为 左闭右闭
		while (min <= max) {
			int mid = ((max - min) >> 1) + min;
			if (exitTreeNode(mid, root, h)) {
				// 如果存在 则继续查找
				ans = mid;
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return ans;		// 在结束二分查找时 min指向的节点是最后一个存在的节点
	}
	private boolean exitTreeNode(int k, TreeNode root, int level) {
		// 获取当前从根节点出发的方向
		int bits = 1 << (level-1);
		TreeNode node = root;
		while (node != null && bits > 0) {
			if ((bits & k) == 0) {
				node = node.left;
			} else {
				node = node.right;
			}
			bits >>= 1;
		}
		return node != null;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}