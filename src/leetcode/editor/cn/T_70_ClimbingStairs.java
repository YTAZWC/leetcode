package leetcode.editor.cn;


/**
 * 70.爬楼梯
 * @author 花木凋零成兰
 * @date 2024-03-31 14:29:38
 */
public class T_70_ClimbingStairs {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_70_ClimbingStairs().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
		if (n == 1)
			return n;
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; ++ i) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}