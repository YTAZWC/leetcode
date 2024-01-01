package leetcode.editor.cn;


import utils.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 429.N 叉树的层序遍历
 * @author 花木凋零成兰
 * @date 2024-01-01 11:07:09
 */
public class T_429_NAryTreeLevelOrderTraversal {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_429_NAryTreeLevelOrderTraversal().new Solution();
	 
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
		if (root == null)
			return ans;		// 考虑边界条件
		Queue<Node> queue = new ArrayDeque<>();
		// 层序遍历
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();	// 记录该层结点值
			for (int i = 0; i < size; ++ i) {
				Node node = queue.poll();
				level.add(node.val);	// 保存记录该层结点
				List<Node> children = node.children;	// 记录该层孩子结点
//				if (children != null) {
//					children.forEach(queue::offer);	// 将该孩子的结点进队 用于下一层遍历
//				}
				for (Node child : children) {	// 增强for 比 lambda表达式开销更低
					queue.offer(child);
				}
			}
			ans.add(level);
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}