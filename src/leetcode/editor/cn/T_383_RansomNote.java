package leetcode.editor.cn;


/**
 * 赎金信
 * @author 花木凋零成兰
 * @date 2023-12-10 16:47:05
 */
public class T_383_RansomNote {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_383_RansomNote().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;	// 若ransomNote得长度大于magazine的长度 则不满足条件
		}
		int lenR = ransomNote.length();		// 字符串 ransomNote 的长度
		int lenM = magazine.length();		// 字符串 magazine 的长度
		int[] hash = new int[26];
		// 遍历字符串 ransomNote
		for (int i = 0; i < lenR; ++i) {
			hash[ ransomNote.charAt(i) - 'a' ] ++;
		}
		// 再遍历字符串 magazine
		for (int i = 0; i < lenM; ++i) {
			hash[ magazine.charAt(i) - 'a' ] --;
		}
		// 遍历哈希数组hash 判断是否满足条件
		for (int i = 0; i < 26; ++i) {
			if (hash[i] > 0)	// 有字符数目大于0 则说明无法构成ransomNote
				return false;
		}
		return true;	// 满足条件
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}