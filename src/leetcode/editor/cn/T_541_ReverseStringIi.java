package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 541.反转字符串 II
 * @author 花木凋零成兰
 * @date 2023-12-17 11:26:04
 */
public class T_541_ReverseStringIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_541_ReverseStringIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
		int n = s.length();		// 字符串长度
		if (n == 1)		// 若字符串长度为1 则不需要反转
			return s;
		char[] str = s.toCharArray();	// 将字符串转化为字符数组
		int i = 0;	// 每次反转字符串的起始点
		while (true) {
			if (n-i >= 2*k) {
				reverseStr(i, i+k-1, str);
				i += 2*k;
			} else if (n-i >= k) {
				reverseStr(i, i+k-1, str);
				break;
			} else {
				reverseStr(i, n-1, str);
				break;
			}
		}
		return new String(str);
	}
	// 反转字符串函数
	public void reverseStr(int left, int right, char[] str) {
		while (left < right) {
			char ch = str[left];
			str[left ++] = str[right];
			str[right --] = ch;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}