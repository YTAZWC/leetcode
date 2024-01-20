package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 513.找树左下角的值
 * @author 花木凋零成兰
 * @date 2024-01-20 20:45:58
 */
public class T_513_FindBottomLeftTreeValue {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_513_FindBottomLeftTreeValue().new Solution();
	 
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
//    public int findBottomLeftValue(TreeNode root) {
//		// List<Integer> ans = new ArrayList<>();
//		int ans = 0;
//		Queue<TreeNode> queue = new ArrayDeque<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			for (int i = 0; i < size; ++ i) {
//				TreeNode node = queue.poll();
//				if (i == 0) ans = node.val;	// 记录每层的最左边的节点
//				if (node.left != null) queue.offer(node.left);
//				if (node.right != null) queue.offer(node.right);
//			}
//		}
//		return ans;	// 返回列表的最后一个节点
//    }

	int curHeight = -1;
	int curVal = 0;		// 记录高度curHeight时 最左节点的值
	public int findBottomLeftValue(TreeNode root) {
		dfs(root, 0);
		return curVal;
	}
	private void dfs(TreeNode node, int height) {
		if (node == null)
			return ;
		// ++ height;	// 此时节点高度+1

		if (height > curHeight) {	// 若当前高度大于记录的高度
			curVal = node.val;	// 更新
			curHeight = height;
		}
		dfs(node.left, height+1);		// 先遍历左子树
		dfs(node.right, height+1);	// 再遍历右子树

	}

}
//leetcode submit region end(Prohibit modification and deletion)

}