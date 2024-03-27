package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * 763.划分字母区间
 * @author 花木凋零成兰
 * @date 2024-03-27 09:29:08
 */
public class T_763_PartitionLabels {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_763_PartitionLabels().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
		int[] hash = new int[27];	// 记录每个字母出现的最大索引
		int length = s.length();	// 获取字符串长度
		char[] str = s.toCharArray();	// 将字符串转化为字符数组
		for (int i = 0; i < length; ++ i) {
			hash[str[i] - 'a'] = i;
		}
		List<Integer> result = new ArrayList<>();	// 记录每个片段长度
		int left = 0;	// 记录片段的左边界
		int right = 0;	// 记录片段的右边界
		for (int i = 0; i < length; ++ i) {
			right = Math.max(right, hash[str[i]-'a']);	// 更新某片段的右边界
			if (i == right) {	// 找到某片段的最远右边界
				result.add(right - left + 1);	// 记录某片段的长度
				left = right + 1;	// 更新为下一个片段左边界
			}
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}