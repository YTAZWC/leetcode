package utils;

import java.util.List;

/**
 * N 叉树
 * @author 花木凋零成兰
 * @date 2024/1/1 11:09
 */
public class Node {

    public int val;
    public List<Node> children; // 孩子结点列表

    public Node(){

    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
