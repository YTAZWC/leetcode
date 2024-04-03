package leetcode.editor.cn;


/**
 * 63.不同路径 II
 * @author 花木凋零成兰
 * @date 2024-04-03 09:19:07
 */
public class T_63_UniquePathsIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_63_UniquePathsIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];	// 状态转移方程为：dp[i][j] = obstacleGrid[i][j] == 1? 0 : dp[i-1][j] + dp[i][j-1]
		// dp初始化
		for (int i = 0; i < m; ++ i) {
			if (obstacleGrid[i][0] == 1) break;
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; ++ j) {
			if (obstacleGrid[0][j] == 1) break;
			dp[0][j] = 1;
		}
		// 状态转移
		for (int i = 1; i < m; ++ i) {
			for (int j = 1; j < n; ++ j) {
				dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}