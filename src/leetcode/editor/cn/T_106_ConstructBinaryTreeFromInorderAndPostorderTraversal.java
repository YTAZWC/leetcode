package leetcode.editor.cn;


import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106.从中序与后序遍历序列构造二叉树
 * @author 花木凋零成兰
 * @date 2024-01-22 14:06:22
 */
public class T_106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
	 
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
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//		if (postorder == null)
//			return null;	// 边界条件
//		// 构造哈希表
//		Map<Integer, Integer> inMap = new HashMap<>();
//		for (int i = 0; i < inorder.length; i++) {
//			inMap.put(inorder[i], i);
//		}
//		return doBuildTree(inorder, postorder, inMap, 0, inorder.length-1, 0, postorder.length-1);
//    }
//	private TreeNode doBuildTree(int[] inorder, int[] postorder, Map<Integer, Integer> inMap, int inS, int inE, int postS, int postE) {
//		if (inE < 0 || postE < 0 || inS > inE || postS > postE || inS >= inorder.length || postS >= postorder.length) // 考虑边界问题
//			return null;
//		// 根据后序遍历数组 末尾索引 获取该子树根节点值
//		int rootValue = postorder[postE];
//		TreeNode node = new TreeNode(rootValue);	// 构造二叉树
//		if (postS == postE)		// 若此时后序数组 起始索引和末尾索引相等 说明为叶子节点
//			return node;	// 直接返回
//		// 根据根节点值 对中序数组进行分割 获取分割位置索引
//		int index = inMap.get(rootValue);
//		// 递归获取左右子树
//		node.left = doBuildTree(inorder, postorder, inMap, inS, index-1, postS, postS+index-1-inS);
//		node.right = doBuildTree(inorder, postorder, inMap, index+1, inE, postS+index-inS, postE-1);
//		return node;
//	}

//	public TreeNode buildTree(int[] inorder, int[] postorder) {
//		if (postorder == null)
//			return null;	// 边界条件
//		// 构造哈希表
//		Map<Integer, Integer> inMap = new HashMap<>();
//		for (int i = 0; i < inorder.length; i++) {
//			inMap.put(inorder[i], i);
//		}
//		return doBuildTree(postorder, inMap, 0, inorder.length-1, 0, postorder.length-1);
//	}
//	private TreeNode doBuildTree(int[] postorder, Map<Integer, Integer> inMap, int inS, int inE, int postS, int postE) {
//		if (inS > inE || postS > postE) // 考虑边界问题
//			return null;
//		// 根据后序遍历数组 末尾索引 获取该子树根节点值
//		int rootValue = postorder[postE];
//		TreeNode node = new TreeNode(rootValue);	// 构造二叉树
//		if (postS == postE)		// 若此时后序数组 起始索引和末尾索引相等 说明为叶子节点
//			return node;	// 直接返回
//		// 根据根节点值 对中序数组进行分割 获取分割位置索引
//		int index = inMap.get(rootValue);
//		// 递归获取左右子树
//		node.left = doBuildTree(postorder, inMap, inS, index-1, postS, postS+index-1-inS);
//		node.right = doBuildTree(postorder, inMap, index+1, inE, postS+index-inS, postE-1);
//		return node;
//	}

	int[] inorder;		// 中序遍历数组
	int[] postorder;	// 后序遍历数组
	Map<Integer, Integer> inMap;	// 中序遍历数组 索引表
	int postIndex;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null)
			return null;	// 边界条件
		this.inorder = inorder;
		this.postorder = postorder;
		postIndex = postorder.length-1;
		// 构造哈希表
		inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inMap.put(inorder[i], i);
		}
		return doBuildTree(0, inorder.length-1);
	}
	private TreeNode doBuildTree(int inLeft, int inRight) {
		if (inLeft > inRight)	// 说明此时为空树
			return null;
		int value = postorder[postIndex];	// 根据postIndex 来确定当前子树 中节点值
		TreeNode node = new TreeNode(value);
		// 根据 中间节点值 获取分割中序数组索引
		int index = inMap.get(value);
		postIndex--;	// 移动所指向的根节点
		// 先获取右子树
		node.right = doBuildTree(index+1, inRight);
		// 再获取左子树
		node.left = doBuildTree(inLeft, index-1);
		return node;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}