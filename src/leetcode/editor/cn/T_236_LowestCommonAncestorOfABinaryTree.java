package leetcode.editor.cn;


import utils.TreeNode;

/**
 * 236.二叉树的最近公共祖先
 * @author 花木凋零成兰
 * @date 2024-02-06 20:15:21
 */
public class T_236_LowestCommonAncestorOfABinaryTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_236_LowestCommonAncestorOfABinaryTree().new Solution();
	 
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
//        return dfs(root, p.val, q.val);
//    }
//    private TreeNode dfs(TreeNode node, int p, int q) {
//        if (node == null)
//            return null;	// 空节点停止判断
//        TreeNode leftDfs = dfs(node.left, p, q);	// 先从左子树判断
//        if (leftDfs != null)	// 若左子树已找到公共祖先 则直接返回
//            return leftDfs;
//        TreeNode rightDfs = dfs(node.right, p, q);	// 再判断右子树
//        if (rightDfs != null)	// 若右子树已找到公共祖先 则直接返回
//            return rightDfs;
//        boolean findP = findTreeNode(node, p);	// 判断节点p是否在该子树上
//        boolean findQ = findTreeNode(node, q);	// 判断节点q是否在该子树上
//        if (findQ && findP)
//            return node;	// 若两节点均在该树上 则返回公共祖先
//        return null;
//    }
//    private Boolean findTreeNode(TreeNode node, int x) {
//        if (node == null)
//            return false;
//        return findTreeNode(node.right, x) || findTreeNode(node.left, x) || node.val == x;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q)
            return node;
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        if (left != null && right != null)
            return node;
        if (left != null)
            return left;
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}