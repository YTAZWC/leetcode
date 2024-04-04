package leetcode.editor.cn;


/**
 * 343.整数拆分
 * @author 花木凋零成兰
 * @date 2024-04-04 13:45:56
 */
public class T_343_IntegerBreak {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_343_IntegerBreak().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
		// dp[i] 含义：将i拆分成多个数，这些数的乘积最大
		int[] dp = new int[n+1];
		// dp数组初始化
		dp[2] = 1;
		// 进行推导
		for (int i = 3; i <= n; ++ i) {
			for (int j = 1; j <= i/2; ++ j) {
				dp[i] = Math.max(dp[i], Math.max(j * dp[i-j], j * (i-j)));
			}
		}
		return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}