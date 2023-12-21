package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Stack;

/**
 * 1047.删除字符串中的所有相邻重复项
 * @author 花木凋零成兰
 * @date 2023-12-21 13:55:40
 */
public class T_1047_RemoveAllAdjacentDuplicatesInString {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_1047_RemoveAllAdjacentDuplicatesInString().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public String removeDuplicates(String s) {
//		int n = s.length();		// 字符串s的长度
//		if (n == 1) return s;	// 字符串只有一个字符 无需删除
//		Stack<Character> stack = new Stack<>();
//		stack.push(s.charAt(0));	// 提前将一个字符压入栈中
//		for (int i = 1; i < n; ++i) {
//			char ch = s.charAt(i);
//			if (!stack.empty() && stack.peek() == ch) {
//				// 若此时栈顶元素与字符串字符相等 则有重复项 并删除
//				stack.pop();
//			} else {
//				stack.push(ch);
//			}
//		}
//		// 栈内剩余字符 即为字符串反复执行重复项删除后的结果
//		// 将其转化为字符串 返回
//		char[] ans = new char[stack.size()];
//		for (int i = ans.length-1; i >= 0; -- i)
//			ans[i] = stack.pop();
//
//		return new String(ans);
//	}

	public String removeDuplicates(String s) {
		int n = s.length();		// 字符串s的长度
		if (n == 1) return s;	// 字符串只有一个字符 无需删除
		char[] stack = new char[50005];
		int index = -1;
		for (int i = 0; i < n; ++i) {
			char ch = s.charAt(i);
			if (index >= 0 && stack[index] == ch) {
				index --;
			} else {
				++ index;
				stack[index] = ch;
			}
		}
		char[] ans = new char[index+1];
		System.arraycopy(stack, 0, ans, 0, index+1);
		return new String(ans);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}