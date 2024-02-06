package leetcode.editor.cn;


import utils.TreeNode;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 501.二叉搜索树中的众数
 * @author 花木凋零成兰
 * @date 2024-02-06 15:33:02
 */
public class T_501_FindModeInBinarySearchTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_501_FindModeInBinarySearchTree().new Solution();
	 
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
	int val;	// 用于记录中序遍历上一个节点的值
	int num;	// 用于记录值等于val的节点个数
	int maxNum;	// 用于记录num出现的最大值
	List<Integer> ans;	// 用于保存记录出现的众数
    public int[] findMode(TreeNode root) {
		val = root.val;	// 初始化为根节点
		ans = new LinkedList<>();
		doFindMode(root);
		updateAns();	// 再进行更新ans 防止漏掉序列最后连续的数值
		int[] arr = new int[ans.size()];
		for (int i = 0; i < ans.size(); ++ i) {
			arr[i] = ans.get(i);
		}
		return arr;
    }
	private void doFindMode(TreeNode node) {
		if (node == null)
			return ;
		doFindMode(node.left);		// 遍历左子树
		if (node.val == val) {
			++ num;
		} else {
			updateAns();	// 对列表进行更新
			val = node.val;
			num = 1;
		}
		doFindMode(node.right);		// 遍历右子树
	}
	private void updateAns() {
		if (num > maxNum) {
			ans.clear();	// 清除记录
			ans.add(val);	// 记录新的众数
			maxNum = num;	// 更新最大num
		} else if (num == maxNum) {
			ans.add(val);	// 增加新的众数
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}