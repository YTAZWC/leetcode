package leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 有效的字母异位词
 * @author 花木凋零成兰
 * @date 2023-12-10 15:29:40
 */
public class T_242_ValidAnagram {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_242_ValidAnagram().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public boolean isAnagram(String s, String t) {
//		if (s.length() != t.length()) {
//			return false;	// 长度不一致 不为字母异位词 返回false
//		}
//		HashMap<Character, Integer> hashS = new HashMap<>();	// 统计字符串s
//		int lenT = s.length();	// 字符串t的长度
//		int lenS = s.length();	// 字符串s的长度
//		for (int i = 0; i < lenS; ++i) {	// 统计字符串s
//			char chS = s.charAt(i);
//			hashS.put(chS, hashS.getOrDefault(chS, 0) + 1);
//		}
//		// 判断t是否与字符串s互为字母异位词
//		for (int i = 0; i < lenT; ++i) {
//			char chT = t.charAt(i);
//			int chCount = hashS.getOrDefault(chT, 0);
//			if (chCount == 0) {		// 说明字符串t出现不满足条件的字符
//				return false;
//			} else {
//				-- chCount;	// 出现一次满足条件的字符 则排除一个字符
//				hashS.put(chT, chCount);
//			}
//		}
//		return true;
//	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;	// 长度不一致 不为字母异位词 返回false
		}
		// 将字符串s转化为字符数组
		char[] sCharArray = s.toCharArray();
		// 将字符串t转化为字符数组
		char[] tCharArray = t.toCharArray();
		// 对两个字符数组进行排序
		Arrays.sort(sCharArray);
		Arrays.sort(tCharArray);
		// 进行判断是否相等
		return Arrays.equals(sCharArray, tCharArray);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}