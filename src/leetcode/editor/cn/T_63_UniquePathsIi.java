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
		 System.out.println(solution.uniquePathsWithObstacles(new int[][]{
				 {1},
				 {0}
		 }));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//		int m = obstacleGrid.length;
//		int n = obstacleGrid[0].length;
//		int[][] dp = new int[m][n];	// 状态转移方程为：dp[i][j] = obstacleGrid[i][j] == 1? 0 : dp[i-1][j] + dp[i][j-1]
//		// dp初始化
//		for (int i = 0; i < m; ++ i) {
//			if (obstacleGrid[i][0] == 1) break;
//			dp[i][0] = 1;
//		}
//		for (int j = 0; j < n; ++ j) {
//			if (obstacleGrid[0][j] == 1) break;
//			dp[0][j] = 1;
//		}
//		// 状态转移
//		for (int i = 1; i < m; ++ i) {
//			for (int j = 1; j < n; ++ j) {
//				dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i-1][j] + dp[i][j-1];
//			}
//		}
//		return dp[m-1][n-1];
//    }

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		// 状态转移方程：dp[j] = obstacleGrid[i][j] == 1 ? 0: dp[j] + dp[j-1]
		int[] dp = new int[n];
		// 初始化dp 即第一行特殊情况
		for (int i = 0; i < n; ++ i) {
			if (obstacleGrid[0][i] == 1) break;
			dp[i] = 1;
		}
		// 用于表示 第一列是否发现障碍物
		// 同时需要考虑 第一列的第一个点 若此时就已为障碍物 则第一列均不可走 路径总数为0
		boolean isFindObstacle = obstacleGrid[0][0] == 1;
        for (int i = 1; i < m; ++ i) {
			for (int j = 0; j < n; ++ j) {
				if (!isFindObstacle && j == 0) {
					if (obstacleGrid[i][j] == 1) {
						isFindObstacle = true;
						dp[j] = 0;
					} else dp[j] = 1;
					continue;
				}
				if (j != 0) dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j-1];
			}
		}
		return dp[n-1];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}