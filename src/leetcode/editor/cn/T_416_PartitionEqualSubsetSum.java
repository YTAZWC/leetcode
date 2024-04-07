package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 416.分割等和子集
 * @author 花木凋零成兰
 * @date 2024-04-07 11:28:59
 */
public class T_416_PartitionEqualSubsetSum {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_416_PartitionEqualSubsetSum().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums) {	// 求和
			sum += num;
		}
		if (sum % 2 == 1) return false;	// 奇数 不能分割等和子集
		int target = sum / 2;
		int[] dp = new int[target + 1];
		// 初始化dp
		dp[0] = 0;
        for (int num : nums) {
            for (int j = target; j >= num; --j) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
		return dp[target] == target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}