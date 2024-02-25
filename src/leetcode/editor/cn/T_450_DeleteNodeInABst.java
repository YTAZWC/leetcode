package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 450.删除二叉搜索树中的节点
 * @author 花木凋零成兰
 * @date 2024-02-25 20:51:55
 */
public class T_450_DeleteNodeInABst {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_450_DeleteNodeInABst().new Solution();
	 
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
//    public TreeNode deleteNode(TreeNode root, int key) {
//		return dfs(root, key);
//    }
//	private TreeNode dfs(TreeNode node, int key) {
//		if (node == null)
//			return null;	// 边界条件
//		if (node.val > key) {
//			node.left = dfs(node.left, key);		// 说明待删除节点在左子树 继续递归
//		} else if (node.val < key) {
//			node.right = dfs(node.right, key);	// 说明待删除节点在右子树 继续递归
//		} else {	// 找到待删除节点
//			if (node.left == null && node.right == null) {
//				return null;
//			} else if (node.left == null || node.right == null) {
//				return node.left == null ? node.right : node.left;	// 返回不为null的子树
//			} else {
//				TreeNode pos = node.right;
//				while (pos.left != null)
//					pos = pos.left;
//				pos.left = node.left;	// 将左子树链接到右子树最左端末尾
//				return node.right;
//			}
//		}
//		return node;
//	}


	public TreeNode deleteNode(TreeNode root, int key) {
		return dfs(root, key);
	}
	private TreeNode dfs(TreeNode node, int key) {
		if (node == null)
			return null;	// 边界条件
		if (node.val > key) {
			node.left = dfs(node.left, key);		// 说明待删除节点在左子树 继续递归
		} else if (node.val < key) {
			node.right = dfs(node.right, key);	// 说明待删除节点在右子树 继续递归
		} else {	// 找到待删除节点
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null || node.right == null) {
				return node.left == null ? node.right : node.left;	// 返回不为null的子树
			} else {
				TreeNode pos = node.right;
				while (pos.left != null)	// 寻找右子树的最左端节点
					pos = pos.left;
				// 右子树的最左端节点作为新的根节点
				node.val = pos.val;		// 将pos节点值赋值给当前根节点 即pos作为新的根节点
				node.right = dfs(node.right, pos.val);	// 删除重复出现的pos节点值
			}
		}
		return node;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}