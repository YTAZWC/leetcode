package leetcode.editor.cn;


/**
 * 53.最大子数组和
 * @author 花木凋零成兰
 * @date 2024-03-15 11:40:49
 */
public class T_53_MaximumSubarray {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_53_MaximumSubarray().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// 贪心
//    public int maxSubArray(int[] nums) {
//		int result = Integer.MIN_VALUE;
//		int count = 0;
//        for (int num : nums) {
//            count += num;
//            if (count > result) // 时刻更新最大和
//				result = count;
//            if (count < 0)
//				count = 0;	// 当连续子数组和小于0时 重置连续和为0
//        }
//		return result;
//    }

	// 动态规划
	public int maxSubArray(int[] nums) {
		// 直接使用nums作为dp数组
		// 公式为：nums[i] = nums[i] + nums[i-1]>0?nums[i-1]:0;
		int ans = nums[0];
		for (int i = 1; i < nums.length; ++ i) {
			if (nums[i-1] > 0) {
				nums[i] += nums[i-1];
			}
			ans = Math.max(ans, nums[i]);
		}
		return ans;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}