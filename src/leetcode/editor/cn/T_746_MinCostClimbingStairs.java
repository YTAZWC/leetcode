package leetcode.editor.cn;


/**
 * 746.使用最小花费爬楼梯
 * @author 花木凋零成兰
 * @date 2024-04-01 09:22:23
 */
public class T_746_MinCostClimbingStairs {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_746_MinCostClimbingStairs().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;	// 获得楼顶
		int[] dp = new int[n+1];	// 记录在第i阶台阶向上爬时 需要花费的费用
		// 初始化dp
		dp[0] = cost[0];	// 从第0阶开始往上爬
		dp[1] = cost[1];	// 从第1阶台阶往上爬
		for (int i = 2; i < n; ++ i) {
			dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
		}
		dp[n] = Math.min(dp[n-1], dp[n-2]);	// 达到楼顶的最低花费
		return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}