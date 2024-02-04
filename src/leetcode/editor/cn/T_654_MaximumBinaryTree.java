package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 654.最大二叉树
 * @author 花木凋零成兰
 * @date 2024-02-04 21:53:09
 */
public class T_654_MaximumBinaryTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_654_MaximumBinaryTree().new Solution();
	 
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
    int[] nums;
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums == null)
			return null;	// 边界情况
		this.nums = nums;
		return doBuildTree(0, nums.length-1);
    }
	private TreeNode doBuildTree(int left, int right) {
		if (left > right)
			return null;	// 说明为空树
		int max = Integer.MIN_VALUE;
		int index = 0;	// 用于标记最大值索引
		for (int i = left; i <= right; ++i) {	// 寻找最大值 以及所对应的索引
			if (nums[i] > max) {
				max = nums[i];
				index = i;
			}
		}
		TreeNode node = new TreeNode(max);	// 构建二叉树
		node.left = doBuildTree(left, index-1);	// 构建左子树
		node.right = doBuildTree(index+1, right);	// 构建右子树
		return node;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}