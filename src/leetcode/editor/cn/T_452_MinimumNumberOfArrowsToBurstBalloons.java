package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 452.用最少数量的箭引爆气球
 * @author 花木凋零成兰
 * @date 2024-03-25 09:18:00
 */
public class T_452_MinimumNumberOfArrowsToBurstBalloons {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_452_MinimumNumberOfArrowsToBurstBalloons().new Solution();
		 int[][] points = new int[][] {
				 {-2147483646,-2147483645},
				 {2147483646,2147483647},
		 };
		 System.out.println(solution.findMinArrowShots(points));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinArrowShots(int[][] points) {
		// 对气球坐标进行排序 便于确定哪些气球可以用同样的箭 爆破
		Arrays.sort(points, (a, b) -> {
			if (a[1] > b[1]) {
				return 1;
			} else if (a[1] < b[1]) {
				return -1;
			} else return 0;
		});
		// System.out.println(Arrays.deepToString(points));	// 测试排序结果
		int count = 1;	// 记录需要使用的箭的数量
		int end = points[0][1];	// 记录箭生效范围的右区间
		for (int[] point : points) {
			if (point[0] > end) {	// 当新气球超过 箭的终止生效范围时
				++ count;	// 需要使用新的箭来爆破气球
				end = point[1];		// 新箭 生效的终止位置
				}
		}
		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}