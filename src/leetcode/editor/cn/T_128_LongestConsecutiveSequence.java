package leetcode.editor.cn;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128.最长连续序列
 * @author 花木凋零成兰
 * @date 2024-07-25 21:25:23
 */
public class T_128_LongestConsecutiveSequence {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_128_LongestConsecutiveSequence().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int longestConsecutive(int[] nums) {
//		int n = nums.length;
//		if (n == 0) {
//			return 0;
//		}
//		// 排序
//		Arrays.sort(nums);
//		// 最小连续序列长度为 1
//		int max = 1;
//		int flag = 1;
//		for (int i = 0; i < n-1; ++ i) {
//			if (nums[i] == nums[i+1] - 1) {
//				// 若连续 则长度增加
//				flag ++;
//			} else if (nums[i] == nums[i+1]) {
//				// 排除连续相等的元素
//				continue;
//			}else {
//				// 不连续 则重新计数
//				flag = 1;
//			}
//			// 时刻更新最长序列
//			max = Math.max(flag, max);
//		}
//		return max;
//    }

	public int longestConsecutive(int[] nums) {
		// 定义哈希表
		Set<Integer> set = new HashSet<>();
		// 遍历数组 并存入哈希表中去重
		for (int num : nums) {
			set.add(num);
		}
		// 最长序列长度
		int maxLen = 0;
		for (Integer num : set) {
			// 判断当前元素是否为序列起点
			if (!set.contains(num-1)) {
				// 为序列起点 遍历序列获取长度
				// 当前元素
				int currentNum = num;
				// 当前序列长度
				int currentLen = 1;
				while (set.contains(currentNum + 1)) {
					// 序列长度增加
					++ currentLen;
					++ currentNum;
				}
				maxLen = Math.max(maxLen, currentLen);
			}
		}
		return maxLen;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}