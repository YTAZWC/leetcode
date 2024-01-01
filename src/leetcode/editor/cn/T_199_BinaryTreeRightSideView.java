package leetcode.editor.cn;


import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199.二叉树的右视图
 * @author 花木凋零成兰
 * @date 2024-01-01 09:58:46
 */
public class T_199_BinaryTreeRightSideView {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_199_BinaryTreeRightSideView().new Solution();
	 
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
    public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;		// 考虑边界情况
		Queue<TreeNode> queue = new ArrayDeque<>();
		// 开始层序遍历
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			// 定义在for循环之外 每次遍历一层二叉树结点后 会记录该层的最后一个结点
			// 即记录每层的最右端结点
			TreeNode node = null;
			// 只需保存该层最末端的结点
			for (int i = 0; i < size; ++ i) {	// 将该层结点弹出 只保留最右端结点
				node = queue.poll();
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			ans.add(node.val);		// 将最右端结点记录
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}