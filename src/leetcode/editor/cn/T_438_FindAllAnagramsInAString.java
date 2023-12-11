package leetcode.editor.cn;


import java.util.*;

/**
 * 438.找到字符串中所有字母异位词
 * @author 花木凋零成兰
 * @date 2023-12-11 11:10:45
 */
public class T_438_FindAllAnagramsInAString {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_438_FindAllAnagramsInAString().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<Integer> findAnagrams(String s, String p) {
//		int lenP = p.length();	// 字符串p的长度
//		int lenS = s.length();	// 字符串s的长度
//		List<Integer> ans = new ArrayList<>();	// 存储返回结果
//		// 存储标识
//		String flag = getFlagStr(p, 0, lenP);
//		// 遍历字符串s 寻找符合条件的异位词
//		for (int i = 0; i+lenP <= lenS; ++i) {
//			String flagStr = getFlagStr(s, i, i+lenP);
//			if (flagStr.equals(flag)) {
//				ans.add(i);
//			}
//		}
//		return ans;
//    }
//	// 根据字符串中的字符及数量拼接成字符串 并返回
//	public String getFlagStr(String str, int start, int end) {
//		int[] count = new int[26];
//		for (int i = start; i < end; ++i) {
//			count[ str.charAt(i) - 'a' ] ++;
//		}
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < 26; ++i) {
//			if (count[i] > 0) {
//				sb.append(i + 'a').append(count[i]);
//			}
//		}
//		return new String(sb);
//	}

//	public List<Integer> findAnagrams(String s, String p) {
//		int lenP = p.length();	// 字符串p的长度
//		int lenS = s.length();	// 字符串s的长度
//
//		List<Integer> ans = new ArrayList<>();	// 存储返回结果
//		if (lenS < lenP) 	// 若字符串s的长度小于字符串p 则直接返回空列表
//			return ans;
//
//		int[] sCount = new int[26];		// 统计s中字符的计数数组
//		int[] pCount = new int[26];		// 统计p中字符的计数数组
//		// 统计p字符串的字符
//		for (int i = 0; i < lenP; ++i) {
//			++ pCount[p.charAt(i) - 'a'];
//			++ sCount[s.charAt(i) - 'a'];	// 先统计s中起始索引为0长度为lenP的子串
//		}
//		if (Arrays.equals(sCount, pCount)) {
//			ans.add(0);		// 若子串符合要求 则存储其起始索引
//		}
//		for (int i = 0; i+lenP < lenS; ++i) {
//			-- sCount[s.charAt(i) - 'a'];	// 排除左窗口起始位置的字符
//			++ sCount[s.charAt(i+lenP) - 'a'];	// 新增右窗口处的字符
//			if (Arrays.equals(sCount, pCount)) {
//				ans.add(i+1);	// 窗口内子串 为异位词 则将起始位置保存
//			}
//		}
//		return ans;
//	}

	public List<Integer> findAnagrams(String s, String p) {
		int lenP = p.length();	// 字符串p的长度
		int lenS = s.length();	// 字符串s的长度
		List<Integer> ans = new ArrayList<>();	// 存储返回结果
		if (lenS < lenP) 	// 若字符串s的长度小于字符串p 则直接返回空列表
			return ans;
		int[] count = new int[26];	// 用于统计字符数
		int distance = 0;	// 用于计数 s子串与字符串p的字符差异个数
		for (int i = 0; i < lenP; ++i) {
			-- count[p.charAt(i) - 'a'];	// p 字符数减少
			++ count[s.charAt(i) - 'a'];	// s 字符数增加
		}
		for (int number : count) {	// 判断s中[0, lenP)的字串是否为 异位词
			if (number != 0) {
				++ distance;
			}
		}
		if (distance == 0) {	// 说明s中[0,lenP)的子串为异位词 将其起始索引保存
			ans.add(0);
		}
		for (int i = 0; i+lenP < lenS; ++i) {
			// 排除左边界处字符
			int chL = s.charAt(i) - 'a';
			-- count[chL];
			if (count[chL] == -1) {	// 说明子串中该字符数目 由符合变不符合
				++ distance;	// 即不符合条件的字符数+1
			} else if (count[chL] == 0) {	// 说明子串中该字符数 由不符合变符合
				-- distance;	// 即符合条件的字符数-1
			}
			// 添加右边界字符
			int chR = s.charAt(i+lenP) - 'a';
			++ count[chR];
			if (count[chR] == 1) {	// 说明子串中该字符数目 由符合变不符合
				++ distance;	// 即不符合条件的字符数+1
			} else if (count[chR] == 0) {	// 说明子串中该字符数 由不符合变符合
				-- distance;	// 即不符合条件的字符数-1
			}
			// 判断新的子串是否 符合异位词
			if (distance == 0) {
				ans.add(i+1);
			}
		}
		return ans;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}