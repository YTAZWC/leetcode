package leetcode.editor.cn;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 435.无重叠区间
 * @author 花木凋零成兰
 * @date 2024-03-26 13:03:23
 */
public class T_435_NonOverlappingIntervals {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_435_NonOverlappingIntervals().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] interval1, int[] interval2) {
				return interval1[1] - interval2[1];
			}
		});	// 对区间集合按右端点进行排序
		int count = 0;	// 记录需要移除的区间的最小数量
		int end = intervals[0][1];
		int len = intervals.length;
		for (int i = 1; i < len; ++ i) {
			if (intervals[i][0] >= end) {	// 若第i个区间为不重复区间
				end = intervals[i][1];	// 更新此时不重复区间的终点位置
			} else ++ count;	// 需要移除的区间数量增加
		}
		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}