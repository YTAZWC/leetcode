package utils;

/**
 * 二叉树
 * @author 花木凋零成兰
 * @date 2023/12/27 13:49
 */
public class TreeNode {

    public int val;    // 节点值
    public TreeNode left;  // 左子树
    public TreeNode right; // 右子树

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
