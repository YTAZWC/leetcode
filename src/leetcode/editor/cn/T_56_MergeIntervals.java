package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56.合并区间
 * @author 花木凋零成兰
 * @date 2024-03-28 12:02:34
 */
public class T_56_MergeIntervals {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_56_MergeIntervals().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (interval1, interval2) -> {
            if (interval1[0] == interval2[0])	// 若左边界相等则按右边界升序排
                return interval1[1] - interval2[1];
            else return interval1[0] - interval2[0];	// 对区间按照 左边界升序排列
        });
		List<int[]> ans = new ArrayList<>();	// 存储合并后的区间
		int left = intervals[0][0];		// 记录合并后的区间左边界
		int right = intervals[0][1];	// 记录合并后的区间右边界
		int len = intervals.length;		// 数组intervals中区间数量
		for (int i = 0; i < len; ++ i) {
			if (intervals[i][0] <= right) {	// 若出现重叠 则进行区间合并
				right = Math.max(right, intervals[i][1]);
			} else {	// 若不出现重叠 则将已重叠区间合并
				ans.add(new int[]{left, right});
				// 合并后 更新下一个需要判断是否重叠区间
				left = intervals[i][0];
				right = intervals[i][1];
			}
			if (i == len-1)	{	// 将最后一个区间记录到合并区间集合中
                ans.add(new int[]{left, right});
            }
		}
		return ans.toArray(new int[ans.size()][]);	// 合并区间后 返回结果
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}