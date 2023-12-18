package leetcode.editor.cn;


/**
 * 151.反转字符串中的单词
 * @author 花木凋零成兰
 * @date 2023-12-18 14:04:49
 */
public class T_151_ReverseWordsInAString {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_151_ReverseWordsInAString().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public String reverseWords(String s) {
//		int n = s.length();		// 字符串s的长度
//		if (n == 1)
//			return s;	// 当只有一个单词时 无需反转
//		StringBuilder ans = new StringBuilder();	// 记录反转后的字符串
//		int slow = n-1;	// 慢指针 记录一个单词的末尾位置
//		while (slow >= 0 && s.charAt(slow) == ' ')
//			-- slow;	// 跳过后置空格 并指向第一个单词的末尾位置
//		int fast = slow;	// 快指针 指向单词的起始位置
//		while (fast >= 0) {
//			// 移动快指针到 一个单词的起始
//			while (fast >= 0 && s.charAt(fast) != ' ')
//				-- fast;
//			// 找到一个单词 则将单词保存到返回值中
//			ans.append(s, fast+1, slow+1).append(' ');
//			// 继续移动慢指针 到下一个单词的末尾位置
//			slow = fast;
//			while (slow >= 0 && s.charAt(slow) == ' ')
//				-- slow;
//			fast = slow;	// 更新快指针下一次移动的起始位置
//		}
//		ans.deleteCharAt(ans.length()-1);	// 删除末尾多余的空格
//		return new String(ans);
//    }

	public String reverseWords(String s) {
		int n = s.length();		// 字符串s的长度
		if (n == 1)
			return s;	// 当只有一个单词时 无需反转
		char[] str = s.toCharArray();	// 将字符串转化为字符数组
		str = removeExtraSpaces(str);	// 去除多余的空格
		// 反转整个字符串
		reverseString(0, str.length-1, str);
		// 反转新字符串数组中的 每个单词
		int start = 0;	// 单词的起始索引
		for (int end = 0; end <= str.length; ++end) {
			if (end == str.length || str[end] == ' ') {	// end==str.length时 反转末尾的单词
				reverseString(start, end-1, str);
				start = end + 1;
			}
		}
		return new String(str);
	}

	// 相向双指针 反转字符串
	private void reverseString(int left, int right, char[] str) {
		while (left < right) {
			// 交换左右指针 指向的数组元素
			str[left] ^= str[right];
			str[right] ^= str[left];
			str[left] ^= str[right];
			// 移动左右指针
			++ left;
			-- right;
		}
	}

	// 去除字符串 前后及中间的多余空格
	private char[] removeExtraSpaces(char[] str) {
		// 使用快慢双指针法
		int n = str.length;		// 数组长度
		int slow = 0;
		for (int fast = 0; fast < str.length; ++fast) {
			if (str[fast] != ' ') {	// 快指针开始遍历一个单词
				if (slow != 0) {	// 若此时遍历的单词不是第一个单词 则需要用空格隔开
					str[slow++] = ' ';
				}
				while (fast < n && str[fast] != ' ')	// 快指针遍历到一个单词的末尾
					str[slow++] = str[fast++];
			}
		}
		// 去除多余空格后的数组 长度为 slow
		// 因此需要返回新的数组
		char[] newStr = new char[slow];
		System.arraycopy(str, 0, newStr, 0, slow);
		return newStr;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}