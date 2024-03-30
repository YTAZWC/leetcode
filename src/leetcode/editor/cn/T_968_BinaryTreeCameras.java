package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 968.监控二叉树
 * @author 花木凋零成兰
 * @date 2024-03-30 12:14:53
 */
public class T_968_BinaryTreeCameras {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_968_BinaryTreeCameras().new Solution();
	 
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
    int result = 0;	// 记录摄像头数量
	public int minCameraCover(TreeNode root) {
		if (installCamera(root) == 0) {
			++ result;	// 根节点需要安装摄像头 即摄像头数量+1
		}
		return result;
    }
	private int installCamera(TreeNode node) {
		if (node == null) {
			return 2;	// 如果是空指针 假定其在摄像头覆盖范围内
		}
		int left = installCamera(node.left);	// 在左子树安装摄像头
		int right = installCamera(node.right);	// 在右子树安装摄像头
		if (left == 2 && right == 2) {
			return 0;	// 若左右子节点均被覆盖 则当前父节点不需要安装摄像头
		}
		if (left == 0 || right == 0) {	// 若左右子节点有一个节点 不被摄像头覆盖
			++ result;	// 则只能在当前节点安装摄像头
			return 1;
		}
		if (left == 1 || right == 1) {
			return 2;	// 若左右子节点中有一个节点安装了摄像头 则当前节点已被覆盖
		}
		return -1;	// 不存在其余情况
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}