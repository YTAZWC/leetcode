package leetcode.editor.cn;


import com.sun.source.tree.Tree;
import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105.从前序与中序遍历序列构造二叉树
 * @author 花木凋零成兰
 * @date 2024-02-04 20:47:45
 */
public class T_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
	 
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
    int[] preorder;	// 前序遍历数组
	int[] inorder;	// 中序遍历数组
	Map<Integer, Integer> inMap;	// 中序遍历数组 索引表
	int preIndex;	// 前序遍历数组 标识根节点值 索引
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null)
			return null;	// 边界条件 数组为空时 返回空树
		// 对全局变量 进行赋值
		this.preorder = preorder;
		this.inorder = inorder;
		inMap = new HashMap<>();
		preIndex = 0;
		// 构建中序遍历数组 索引表
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		return doBuildTree(0, inorder.length-1);	// 递归构建二叉树
    }
	private TreeNode doBuildTree(int inLeft, int inRight) {
		if (inLeft > inRight)
			return null;	// 若左端点 大于 右端点 则为空树
		int value = preorder[preIndex];		// 获取 树 根节点值
		TreeNode node = new TreeNode(value);	// 构建树
		int index = inMap.get(value);	// 根据 根节点值 获取分割中序数组索引
		preIndex ++;	// 移动根节点索引
		// 先构建左子树
		node.left = doBuildTree(inLeft, index - 1);
		// 再构建右子树
		node.right = doBuildTree(index + 1, inRight);
		return node;	// 构建完成后 将树返回
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}