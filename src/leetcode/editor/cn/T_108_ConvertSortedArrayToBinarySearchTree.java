package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 108.将有序数组转换为二叉搜索树
 * @author 花木凋零成兰
 * @date 2024-02-26 14:28:28
 */
public class T_108_ConvertSortedArrayToBinarySearchTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_108_ConvertSortedArrayToBinarySearchTree().new Solution();
	 
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
    public TreeNode sortedArrayToBST(int[] nums) {
		return toBSTBySortArray(nums, 0, nums.length-1);	// 注意转递区间为左闭右闭区间
    }
	private TreeNode toBSTBySortArray(int[] nums, int left, int right) {
		if (left > right)
			return null;	// 说明此时为空数组
		int rootValIndex = ((right - left) >> 1) + left;	// 获取根节点的索引
		TreeNode root = new TreeNode(nums[rootValIndex]);
		root.left = toBSTBySortArray(nums, left, rootValIndex-1);	// 构造左子树
		root.right = toBSTBySortArray(nums, rootValIndex+1, right);	// 构造右子树
		return root;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}