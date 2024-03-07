package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * 93.复原 IP 地址
 * @author 花木凋零成兰
 * @date 2024-03-07 13:44:46
 */
public class T_93_RestoreIpAddresses {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_93_RestoreIpAddresses().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<String> ans = new ArrayList<>();
	StringBuffer path = new StringBuffer();
	int numberOfSeparations = 0;	// 确定得到的path中包含四个整数
	int length;		// 记录字符串s长度
    public List<String> restoreIpAddresses(String s) {
		length = s.length();
		backtracking(s, 0);
		return ans;
    }
	private void backtracking(String s, int startIndex) {
		if (numberOfSeparations > 4) return ;	// 剪枝 排除无效IP
		if (startIndex == length && numberOfSeparations == 4) {
			// 说明已经找到有效IP地址
			ans.add(path.toString());
			return ;
		}
		for (int i = startIndex; i < length; ++ i) {
			if (i - startIndex < 3 && isEffectiveInt(s, startIndex, i+1)) {
				// 找到有效数字
				int size = path.length();	// 添加有效数字前字符串长度
				path.append(s, startIndex, i+1);
				if (i+1 != length)	// 分割符放置在字符串中
					path.append(".");
				++ numberOfSeparations;		// 统计已分隔得到的整数个数
				backtracking(s, i+1);		// 继续递归 分隔
				path.delete(size, path.length());	// 回溯
				-- numberOfSeparations;
			}
		}
	}
	// 判断切割得到的整数 是否有效
	private boolean isEffectiveInt(String s, int start, int end) {
		int x = 0;
		if (end-start == 1)
			return true;	// 若切割得到的整数只有1位 则必定有效
		for (int i = start; i < end; ++ i) {
			if (i == start && s.charAt(i) == '0') // 切割的数字含有前导0 无效
				return false;
			x = x*10 + (s.charAt(i)-'0');
		}
		return x >= 0 && x <= 255;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}