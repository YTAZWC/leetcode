package leetcode.editor.cn;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 637.二叉树的层平均值
 * @author 花木凋零成兰
 * @date 2024-01-01 10:35:57
 */
public class T_637_AverageOfLevelsInBinaryTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_637_AverageOfLevelsInBinaryTree().new Solution();
	 
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
    public List<Double> averageOfLevels(TreeNode root) {
		List<Double> ans = new ArrayList<>();
		if (root == null)
			return ans;		// 照常判断边界条件
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0;		// 计算该层 结点值的和
			for (int i = 0; i < size; ++ i) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			ans.add(sum / size);
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}