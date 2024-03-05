package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * 17.电话号码的字母组合
 * @author 花木凋零成兰
 * @date 2024-03-05 14:14:31
 */
public class T_17_LetterCombinationsOfAPhoneNumber {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_17_LetterCombinationsOfAPhoneNumber().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	char[][] charArr = new char[][]{
			{' '},
			{' '},
			{'a', 'b', 'c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'}
	};
	List<String> ans = new ArrayList<>();
	StringBuffer path = new StringBuffer();
	public List<String> letterCombinations(String digits) {
		if (digits.isEmpty())
			return ans;	// 特殊情况
		backtracking(digits.length(), 0, digits);
		return ans;
    }
	private void backtracking(int high, int currentHigh, String digits) {
		if (currentHigh == high) {
			// 获得一个字符组合
			ans.add(path.toString());
			return ;
		}
		// 根据当前递归高度 获取待选取的字符数组
		int index = digits.charAt(currentHigh) - '0';
		for (char ch : charArr[index]) {
			path.append(ch);
			backtracking(high, currentHigh+1, digits);
			path.deleteCharAt(path.length()-1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}