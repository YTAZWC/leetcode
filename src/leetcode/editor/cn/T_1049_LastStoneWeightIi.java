package leetcode.editor.cn;


/**
 * 1049.最后一块石头的重量 II
 * @author 花木凋零成兰
 * @date 2024-04-08 08:58:41
 */
public class T_1049_LastStoneWeightIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_1049_LastStoneWeightIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastStoneWeightII(int[] stones) {
		// 思路：尽可能将石头分为两堆重量近似相等的石头堆 如此两堆石头相撞
		// 即可得到 最小的可能重量
		// 即 考虑如何将 石头分为重量近似相等的两堆石头
		int sum = 0;
		for (int stone : stones) {	// 求石头总和
			sum += stone;
		}
		int target = sum / 2;
		int[] dp = new int[target+1];
		for (int stone : stones) {
			for (int j = target; j >= stone; -- j) {
				dp[j] = Math.max(dp[j], dp[j - stone] + stone);
			}
		}
		// 由此得出一堆石头重量为 dp[target] 另一堆石头重量为 sum-dp[target]
		// 因为尽可能凑成重量为target的石头堆 所以dp[target] <= target
		// 因为石头重量和可能为奇数 所以target <= sum-target 即dp[target] <= sum - dp[target]
		// 所以两堆石头相撞 最终剩余重量为 sum - dp[target] - dp[target]
		return sum - dp[target] - dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}