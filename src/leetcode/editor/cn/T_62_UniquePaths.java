package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 62.不同路径
 * @author 花木凋零成兰
 * @date 2024-04-02 09:16:54
 */
public class T_62_UniquePaths {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_62_UniquePaths().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int uniquePaths(int m, int n) {
//		int[][] dp = new int[m][n];	// dp[i][j] 表示到达点(i, j) 有多少条路径
//		// dp 初始化
//		for (int i = 0; i < m; ++ i) {
//			dp[i][0] = 1;
//		}
//		for (int j = 0; j < n; ++ j) {
//			dp[0][j] = 1;
//		}
//		// 状态转移 遍历dp
//		for (int i = 1; i < m; ++ i) {
//			for (int j = 1; j < n; ++ j) {
//				dp[i][j] = dp[i-1][j] + dp[i][j-1];	// 状态转移方程
//			}
//		}
//		return dp[m-1][n-1];
//    }

	// 压缩状态 —— 滚动数组
	public int uniquePaths(int m, int n) {
		int[] dp = new int[n];
		// 初始化dp
        Arrays.fill(dp, 1);
		for (int i = 1; i < m; ++ i) {
			for (int j = 1; j < n; ++ j) {
				dp[j] += dp[j-1];
			}
		}
		return dp[n-1];
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}