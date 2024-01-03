package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 117.填充每个节点的下一个右侧节点指针 II
 * @author 花木凋零成兰
 * @date 2024-01-03 10:46:10
 */
public class T_117_PopulatingNextRightPointersInEachNodeIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_117_PopulatingNextRightPointersInEachNodeIi().new Solution();
	 
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
//        if (root != null) {
//			Queue<Node> queue = new ArrayDeque<>();
//			queue.offer(root);
//			while (!queue.isEmpty()) {
//				int size = queue.size();
//				for (int i = 0; i < size; ++ i) {
//					Node node = queue.poll();
//					if (i == size-1)	// 如果是本层最后一个结点则next指向null
//						node.next = null;
//					else node.next = queue.peek();	// 不是本层最后一个结点 则指向下一个右侧节点
//					if (node.left != null)
//						queue.offer(node.left);
//					if (node.right != null)
//						queue.offer(node.right);
//				}
//			}
//		}
//		return root;
//    }

	Node last = null;		// 记录某层已建立next连接的最后一个节点
	Node nextStart = null;	// 记录某层的最左节点 即遍历某层的开始节点
	public Node connect(Node root) {
		if (root != null) {
			Node start = root;
			while (start != null) {
				last = null;
				nextStart = null;
				for (Node p = start; p != null; p = p.next) {
					if (p.left != null) {	// 若该节点左子节点不为空 则连接
						handle(p.left);
					}
					if (p.right != null) {	// 若该节点右子节点不为空 则连接
						handle(p.right);
					}
				}
				start = nextStart;	// 更新遍历某层的起始节点
			}
		}
		return root;
	}
	private void handle(Node p) {
		if (last != null) {		// 若连接的节点不是第一个节点 则直接连接
			last.next = p;
		} else {		// 若连接的节点是第一个节点 则记录
			nextStart = p;
		}
		last = p;	// 更新某层已建立next连接的最后一个节点
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