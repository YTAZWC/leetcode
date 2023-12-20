package leetcode.editor.cn;


/**
 * 459.重复的子字符串
 * @author 花木凋零成兰
 * @date 2023-12-19 15:25:02
 */
public class T_459_RepeatedSubstringPattern {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_459_RepeatedSubstringPattern().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public boolean repeatedSubstringPattern(String s) {
//		int n = s.length();
//		for (int i = 1; i <= n/2; ++i) {	// i指子串长度
//			if (n % i == 0) {
//				boolean flag = true;
//				for (int j = i; j < n; ++ j) {	// 遍历判断字符串s是否由长度为i的子串构成
//					if (s.charAt(j) != s.charAt(j-i)) {
//						flag = false;
//						break;
//					}
//				}
//				if (flag) return true;	// 出现一个满足条件的子串 则返回true
//			}
//		}
//		return false;
//    }

//	public boolean repeatedSubstringPattern(String s) {
//		return (s+s).indexOf(s, 1) != s.length();
//	}

//	public boolean repeatedSubstringPattern(String s) {
//		return kmp(s+s, s);
//	}
//	private boolean kmp(String s, String t) {
//		int sLen = s.length();	// 字符串s的长度
//		int tLen = t.length();	// 字符串t的长度
//		int[] next = new int[tLen];		// 创建next数组
//		// 初始化next数组
//		int j = -1;
//		next[0] = j;
//		for (int i = 1; i < tLen; ++i) {
//			while (j >= 0 && t.charAt(i) != t.charAt(j+1)) {
//				j = next[j];
//			}
//			if (t.charAt(i) == t.charAt(j+1))
//				++ j;
//			next[i] = j;
//		}
//		// 判断字符串t是否在字符串s中
//		j = -1;	// 与初始化next数组时对应
//		for (int i = 1; i < sLen-1; ++i) {	// 只能判断子串t是否在字符串s[1:n-1)中
//			while (j >= 0 && s.charAt(i) != t.charAt(j+1)) {
//				j = next[j];
//			}
//			if (s.charAt(i) == t.charAt(j+1)) {
//				++ j;
//			}
//			if (j == tLen-1) {
//				return true;
//			}
//		}
//		return false;
//	}

	public boolean repeatedSubstringPattern(String s) {
		int n = s.length();	// 字符串s的长度
		int[] next = new int[n];	// next数组对应s的前缀表 右移
		int j = -1;
		next[0] = j;
		for (int i = 1; i < n; ++i) {
			while (j >= 0 && s.charAt(i) != s.charAt(j+1)) {
				j = next[j];
			}
			if (s.charAt(i) == s.charAt(j+1)) {
				++ j;
			}
			next[i] = j;
		}
		// 因为next数组对应s的前缀表右移一位
		// 所以next[n-1]表示的是s具有长度为next[n-1]的相同前后缀的值-1
		// 所以计算时字符串s相同前后缀的长度为 next[n-1]+1
		// 所以判断 n 与 n-next[n-1]-1
		// 且需要注意next[n-1]+1 应该大于等于0 保证字符串s具有相同的前后缀
        return next[n-1] >= 0 && n % (n - next[n - 1] - 1) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}