package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 701.二叉搜索树中的插入操作
 * @author 花木凋零成兰
 * @date 2024-02-24 20:38:57
 */
public class T_701_InsertIntoABinarySearchTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_701_InsertIntoABinarySearchTree().new Solution();
	 
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
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//		if (root == null)
//			return new TreeNode(val);
//		if (val < root.val) {
//			root.left = insertIntoBST(root.left, val);
//		} else {
//			root.right = insertIntoBST(root.right, val);
//		}
//		return root;
//    }

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);	// 直接创建新的二叉搜索树
		TreeNode node = root;	// 遍历二叉搜索树节点
		while (node != null) {
			if (val < node.val) {
				if (node.left == null) {
					node.left = new TreeNode(val);	// 找到插入位置并插入
					break;
				} else {
					node = node.left;
				}
			} else {
				if (node.right == null) {
					node.right = new TreeNode(val);
					break;
				} else {
					node = node.right;
				}
			}
		}
		return root;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}