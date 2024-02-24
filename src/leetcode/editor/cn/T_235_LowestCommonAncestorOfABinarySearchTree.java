package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 235.二叉搜索树的最近公共祖先
 * @author 花木凋零成兰
 * @date 2024-02-24 19:52:55
 */
public class T_235_LowestCommonAncestorOfABinarySearchTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_235_LowestCommonAncestorOfABinarySearchTree().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || root == p || root == q)
//        	return root;	// 边界条件 及返回条件
//        TreeNode left = lowestCommonAncestor(root.left, p, q);		// 遍历左
//        TreeNode right = lowestCommonAncestor(root.right, p, q);	// 遍历右
//        // 对左右子树遍历结果进行判断
//        if (left != null && right != null)
//            return root;	// 两者遍历均不为空 说明当前节点即为最近公共祖先
//        if (left != null)
//            return left;	// left不为null 而right为null 说明最近公共祖先在左子树
//        return right;		// 最近公共祖先不在左子树 也不是当前节点 即只能在右子树
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while (true) {
            if (p.val < ans.val && q.val < ans.val) {
                ans = ans.left;		// 节点值均小于中间节点 最近公共祖先在左子树
            } else if (p.val > ans.val && q.val > ans.val) {
                ans = ans.right;	// 节点值均小于中间节点 最近公共祖先在右子树
            } else break;	// 此时当前节点即为最近公共祖先
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}