package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * @author 花木凋零成兰
 * @date 2023-12-04 13:53:23
 */
public class T_54_SpiralMatrix {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_54_SpiralMatrix().new Solution();
		 System.out.println(solution.spiralOrder(new int[][]{
				 {1,2,3,4},
				 {5,6,7,8},
				 {9,10,11,12},
		 }));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		int t = 0;		// 上边边界
		int b = matrix.length - 1;	// 下边边界
		int l = 0;		// 左边边界
		int r = matrix[0].length - 1;	// 右边边界
		while (true) {
			// 上边 从左往右
			for (int j = l; j <= r; ++j) {
				ans.add(matrix[t][j]);
			}
			if (++ t > b) break; // 已经遍历完则退出循环
			// 右边 从上往下
			for (int i = t; i <= b; ++i) {
				ans.add(matrix[i][r]);
			}
			if (-- r < l) break;
			// 下边 从右往左
			for (int j = r; j >= l; --j) {
				ans.add(matrix[b][j]);
			}
			if (-- b < t) break;
			// 左边 从下往上
			for (int i = b; i >= t; --i) {
				ans.add(matrix[i][l]);
			}
			if (++ l > r) break;
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}