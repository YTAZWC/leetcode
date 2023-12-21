package leetcode.editor.cn;


import javax.swing.plaf.nimbus.State;
import java.util.Stack;

/**
 * 20.有效的括号
 * @author 花木凋零成兰
 * @date 2023-12-21 12:10:03
 */
public class T_20_ValidParentheses {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_20_ValidParentheses().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
		int n = s.length();		// 字符串s的长度
		if (n == 1) 	// 只有一个字符时
			return false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < n; ++i) {
			char ch1 = s.charAt(i);
			if (ch1 == '(' || ch1 == '[' || ch1 == '{')	{
				// 若为左括号 则入栈
				stack.push(ch1);
			} else {
				// 为右括号 则出栈一个元素
				if (stack.empty()) return false;	// 若栈为空 则返回false
				char ch2 = stack.pop();	// 出栈
				if (	// 匹配括号是否配对
					(ch1 == ')' && ch2 != '(') ||
					(ch1 == ']' && ch2 != '[') ||
					(ch1 == '}' && ch2 != '{')
				) {
					return false;
				}
			}
		}
        return stack.empty();	// 若此时栈为空 则说明字符串里括号成功匹配结束
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}