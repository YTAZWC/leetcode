package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 116.填充每个节点的下一个右侧节点指针
 * @author 花木凋零成兰
 * @date 2024-01-02 19:34:22
 */
public class T_116_PopulatingNextRightPointersInEachNode {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_116_PopulatingNextRightPointersInEachNode().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
//    public Node connect(Node root) {
//        if (root == null)
//			return null;
//		Queue<Node> queue = new ArrayDeque<>();
//		queue.offer(root);
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			for (int i = 0; i < size; ++ i) {
//				Node node = queue.poll();
//				if (i == size-1) // 此时节点为一层最后的节点
//					node.next = null;
//				else // 若不为最后一层节点 则指向队列中的下一个即可
//					node.next = queue.peek();
//				if (node.left != null) queue.offer(node.left);
//				if (node.right != null) queue.offer(node.right);
//			}
//		}
//		return root;
//    }


	public Node connect(Node root) {
		if (root != null)
			FConnect(root.left, root.right);
		return root;
	}
	private void FConnect(Node left, Node right) {
		if (left == null || left.next == right || right == null)
			return ;
		left.next = right;
		FConnect(left.left, left.right);
		FConnect(left.right, right.left);
		FConnect(right.left, right.right);
	}

}
//leetcode submit region end(Prohibit modification and deletion)
class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}
}