package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 225.用队列实现栈
 * @author 花木凋零成兰
 * @date 2023-12-21 10:43:52
 */
public class T_225_ImplementStackUsingQueues {
	 public static void main(String[] args) {
	     //测试代码
         MyStack myStack = new T_225_ImplementStackUsingQueues().new MyStack();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
//class MyStack {
//
//    Queue<Integer> queue;
//    Queue<Integer> temp;
//
//    public MyStack() {
//        queue = new ArrayDeque<>();
//        temp = new ArrayDeque<>();
//    }
//
//    public void push(int x) {
//        // 先将主队列元素移到副队列
//        while (!queue.isEmpty()) {
//            temp.offer(queue.poll());
//        }
//        // 再将当前元素加入到主队列中 作为后进先出 将第一个出栈
//        queue.offer(x);
//        // 再将副队列元素移到主队列中
//        while (!temp.isEmpty()) {
//            queue.offer(temp.poll());
//        }
//    }
//
//    public int pop() {
//        // 队列中已排好顺序 直接弹出
//        return queue.poll();
//    }
//
//    public int top() {
//        // 直接获取
//        return queue.peek();
//    }
//
//    public boolean empty() {
//        return queue.isEmpty();
//    }
//}

class MyStack {

    Deque<Integer> deque;

    public MyStack() {
        deque = new ArrayDeque<>();
    }

    public void push(int x) {
        deque.offerLast(x);  // 从队列尾部入队
    }

    public int pop() {
        return deque.pollLast();   // 从队列末尾出队
    }

    public int top() {
        return deque.peekLast();    // 获取队列尾部元素
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}