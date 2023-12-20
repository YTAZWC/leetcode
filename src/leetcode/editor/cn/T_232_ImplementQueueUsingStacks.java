package leetcode.editor.cn;


import java.util.Stack;

/**
 * 232.用栈实现队列
 * @author 花木凋零成兰
 * @date 2023-12-20 20:18:55
 */
public class T_232_ImplementQueueUsingStacks {
	 public static void main(String[] args) {
	     //测试代码
         MyQueue myQueue = new T_232_ImplementQueueUsingStacks().new MyQueue();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {

    Stack<Integer> stack;   // 主栈
    Stack<Integer> temp;    // 副栈

    public MyQueue() {
        stack = new Stack<>();
        temp = new Stack<>();
    }
    
    public void push(int x) {
        // 先将之前的元素移到副栈中
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
        stack.push(x);  // 再将新元素追加到队列末尾
        // 将副栈的元素重新移回主栈
        while (!temp.empty()) {
            stack.push(temp.pop());
        }
    }
    
    public int pop() {
        // 弹出队列头元素
        return stack.pop();
    }
    
    public int peek() {
        // 获取队列头元素
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.empty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}