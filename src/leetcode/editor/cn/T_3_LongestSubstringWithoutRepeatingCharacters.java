package leetcode.editor.cn;


/**
 * 3.无重复字符的最长子串
 * @author 花木凋零成兰
 * @date 2024-07-27 22:40:01
 */
public class T_3_LongestSubstringWithoutRepeatingCharacters {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_3_LongestSubstringWithoutRepeatingCharacters().new Solution();
	 	solution.lengthOfLongestSubstring(" ");
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// 滑动窗口
    public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		// 无重复字符串 左边界
		int start = 0;
		// 哈希表 记录对应字符所处位置索引
		int[] hash = new int[129];
		for (int i = 0; i < 129; i++) {
			hash[i] = -1;
		}
		for (int i = 0; i < n; ++ i) {
			// 获取当前字符
			int ch = s.charAt(i);
			start = Math.max(start, hash[ch]+1);
			ans = Math.max(ans, i - start + 1);
			hash[ch] = i;
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}