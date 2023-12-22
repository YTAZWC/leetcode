package leetcode.editor.cn;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 150.逆波兰表达式求值
 * @author 花木凋零成兰
 * @date 2023-12-22 09:03:25
 */
public class T_150_EvaluateReversePolishNotation {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_150_EvaluateReversePolishNotation().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
		Deque<Integer> deque = new LinkedList<>();	// 辅助计算栈
		for (String str: tokens) {    //遍历字符串数组
			if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				// 当字符串是运算符号时 从栈中取出两个元素 执行计算
				int num1 = deque.pop();
				int num2 = deque.pop();
				// 需要注意 在执行二元运算时 二元的顺序 应该nums2在前nums1在后
				switch (str) {
					case "+" :
						deque.push(num2+num1);
						break;
					case "-" :
						deque.push(num2-num1);
						break;
					case "*":
						deque.push(num2*num1);
						break;
					case "/":
						deque.push(num2/num1);
					default:
				}
			} else {
				deque.push(Integer.parseInt(str));
			}
		}
		return deque.pop();		// 栈中最后一个元素 即为表达式计算结果
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}