package leetcode.editor.cn;


import utils.Node;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * 559.N 叉树的最大深度
 * @author 花木凋零成兰
 * @date 2024-01-07 19:36:21
 */
public class T_559_MaximumDepthOfNAryTree {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_559_MaximumDepthOfNAryTree().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
//    public int maxDepth(Node root) {
//        int ans = 0;
//		if (root == null)
//			return ans;		// 边界条件
//		Queue<Node> queue = new ArrayDeque<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			++ ans;	// 遍历一层 深度+1
//			for (int i = 0; i < size; ++ i) {
//				Node node = queue.poll();
//				for (Node child: node.children) {
//					queue.offer(child);	// 将下一层节点入队
//				}
//			}
//		}
//		return ans;
//    }

//	int ans = 0;	// 前序遍历求深度
//	public int maxDepth(Node root) {
//		getMaxDepth(root, 1);
//		return ans;
//	}
//	private void getMaxDepth(Node node, int depth) {
//		if (node == null)
//			return ;	// 边界条件
//		// 中
//		ans = Math.max(ans, depth);
//		// 遍历N个孩子 以左开始
//		for (Node child: node.children) {
//			getMaxDepth(child, depth+1);
//		}
//	}

	public int maxDepth(Node root) {
		return getHeight(root);
	}
	// 后序遍历求某节点的高度
	private int getHeight(Node node) {
		if (node == null)
			return 0;	// 空节点 高度为0
		int height = 0;
		for (Node child: node.children) {
			height = Math.max(getHeight(child), height);
		}
		return height+1;
	}

}
//leetcode submit region end(Prohibit modification and deletion)
}