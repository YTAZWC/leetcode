package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * 131.分割回文串
 * @author 花木凋零成兰
 * @date 2024-03-07 11:11:48
 */
public class T_131_PalindromePartitioning {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_131_PalindromePartitioning().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<String>> ans = new ArrayList<>();	// 存储符合条件的子串列表
	List<String> path = new ArrayList<>();	// 存储切割后的子串
    public List<List<String>> partition(String s) {
		backtracking(s, 0);
		return ans;
    }
	private void backtracking(String s, int startIndex) {
		if (startIndex == s.length()) {
			ans.add(new ArrayList<>(path));
			return ;
		}
		for (int i = startIndex+1; i <= s.length(); ++ i) {
			if (isPalindrome(s, startIndex, i)) {	// 若分割得到的子串为字符串
				path.add(s.substring(startIndex, i));	// 将符合题意的子串记录
				backtracking(s, i);		// 继续分割字符串 得到新的子串
				path.remove(path.size()-1);	// 回溯
			}
		}
	}
	private boolean isPalindrome(String s, int startIndex, int endIndex) {	// 判断某字符串是否为回文串
		while (startIndex < endIndex) {
			if (s.charAt(startIndex) != s.charAt(endIndex-1))
				return false;
			++ startIndex;
			-- endIndex;
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}