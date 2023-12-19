package leetcode.editor.cn;


/**
 * 28.找出字符串中第一个匹配项的下标
 * @author 花木凋零成兰
 * @date 2023-12-19 10:17:37
 */
public class T_28_FindTheIndexOfTheFirstOccurrenceInAString {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_28_FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int strStr(String haystack, String needle) {
//		int hLen = haystack.length();	// 字符串haystack的长度
//		int nLen = needle.length();		// 字符串needle的长度
//		int[] next = new int[nLen];		// 前缀表对应的数组 即就是前缀表
//		// 初始化next数组
//		getNext(next, needle);
//		// 进行判断 needle是否为haystack的子串
//		int j = 0;	// 与初始化next数组时的j对应
//		for (int i = 0; i < hLen; ++i) {
//			while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
//				j = next[j-1];
//			}
//			if (haystack.charAt(i) == needle.charAt(j))	// 匹配移动指针j
//				++ j;
//			if (j == nLen) {	// 说明needle是haystack的子串
//				return i - nLen + 1;
//			}
//		}
//		return -1;
//    }
//	private void getNext(int[] next, String t) {
//		int j = 0;	// 从0开始
//		next[0] = j;
//		int n = t.length();
//		for (int i = 1; i < n; ++ i) {
//			while (j > 0 && t.charAt(i) != t.charAt(j)) {
//				j = next[j-1];
//			}
//			if (t.charAt(i) == t.charAt(j))
//				++ j;
//			next[i] = j;
//		}
//	}

	public int strStr(String haystack, String needle) {
		int hLen = haystack.length();	// 字符串haystack的长度
		int nLen = needle.length();		// 字符串needle的长度
		int[] next = new int[nLen];		// 前缀表对应的数组 即就是前缀表
		// 初始化next数组
		getNext(next, needle);
		// 进行判断 needle是否为haystack的子串
		int j = -1;	// 与初始化next数组时的j对应
		for (int i = 0; i < hLen; ++i) {
			while (j >= 0 && haystack.charAt(i) != needle.charAt(j+1)) {
				j = next[j];
			}
			if (haystack.charAt(i) == needle.charAt(j+1))	// 匹配移动指针j
				++ j;
			if (j == nLen-1) {	// 说明needle是haystack的子串
				return i - nLen + 1;
			}
		}
		return -1;
	}
	private void getNext(int[] next, String t) {
		int j = -1;	// 从0开始
		next[0] = j;
		int n = t.length();
		for (int i = 1; i < n; ++ i) {
			while (j >= 0 && t.charAt(i) != t.charAt(j+1)) {
				j = next[j];
			}
			if (t.charAt(i) == t.charAt(j+1))
				++ j;
			next[i] = j;
		}
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}