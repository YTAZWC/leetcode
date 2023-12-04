package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 螺旋矩阵 II
 * @author 花木凋零成兰
 * @date 2023-12-04 10:33:00
 */
public class T_59_SpiralMatrixIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_59_SpiralMatrixIi().new Solution();
		 System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
		if (n == 1) return new int[][]{{1}};	// n为1时直接返回
		int[][] ans = new int[n][n];
		int loop = n/2;		// 需要旋转的圈数
		int startX = 0;			// 定义起始位置x坐标
		int startY = 0;			// 定义起始位置y坐标
		int offset = 1;			// 控制每次遍历的长度
		int mid = n/2;		// n为奇数时 需要给矩阵中点重新赋值
		int i, j;
		int count = 1;
		// 采用左闭右开
		while (loop > 0) {
			i = startX;
			j = startY;
			// 从左往右
			for (j = startY; j < n-offset; ++ j) {
				ans[i][j] = count++;
			}
			// 从上往下
			for (i = startX; i < n-offset; ++i) {
				ans[i][j] = count++;
			}
			// 从右往左
			for (; j > startY; --j) {
				ans[i][j] = count++;
			}
			// 从下网上
			for (; i > startX; --i) {
				ans[i][j] = count++;
			}
			startY++;
			startX++;
			offset += 1;

			loop--;
		}
		if (n % 2 == 1) ans[mid][mid] = count;

		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}