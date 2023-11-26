package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author 花木凋零成兰
 * @date 2023-11-26 11:16:52
 */
public class T_34_FindFirstAndLastPositionOfElementInSortedArray {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
		 System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
		int start = -1;	// 存储元素的第一个位置
		int end = -1;	// 存储元素的最后一个位置

		// 左闭右开区间 查找元素的最后一个位置
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = ((right - left) >> 1) + left;		// 防止溢出
			if (nums[mid] < target) {
				// 说明目标值在区间的右半部分 [mid+1, right)
				left = mid + 1;
			} else if (nums[mid] > target) {
				// 说明目标值在区间的左半部分 [left, mid)
				right = mid;
			} else {
				// 查找到元素的最后一个位置 退出循环
				end = mid;
				break;
			}
		}

		// 左开右闭区间 查找元素的第一个位置
		left = -1;
		right = nums.length-1;
		while (left < right) {
			int mid = ((right - left) >> 1) + left;
			if (nums[mid] < target) {	// 说明目标值在区间右半部分 (mid, right]
				left = mid;
			} else if (nums[mid] > target) { 	// 说明目标值在区间左半部分 (left, mid-1]
				right = mid - 1;
			} else {	// 查找到元素的第一个位置 退出循环
				start = mid;
				break;
			}
		}


		return new int[] {start, end};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}