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
		 System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
/*		// 获取 target 的右边界且不包含target
		int rightBorder = getRightBorder(nums, target);
		// 获取 target 的左边界且不包含target
		int leftBorder = getLeftBorder(nums, target);

		if (rightBorder == -2 || leftBorder == -2) {
			// 说明target在数组范围的左边或右边
			return new int[]{-1, -1};
		}
		rightBorder -= 1;
		leftBorder += 1;
		if (nums[rightBorder] != target || nums[leftBorder] != target) {
			// 说明target在数组范围内 但不在数组中
			return new int[]{-1, -1};
		}
		return new int[]{leftBorder, rightBorder};*/

		// 解法二
		// 二分查找 数组中是否存在目标值
		int flag = searchBinary(nums, target);
		if (flag == -1) {
			return new int[]{-1, -1};
		}
		// 如果存在 则滑动指针来寻找
		int right = flag;		// 根据查找到的位置来寻找右边界
		while (right + 1 < nums.length && nums[right + 1] == target)
			++ right;
		int left = flag;		// 根据查找到的位置来寻找左边界
		while (left - 1 >= 0 && nums[left - 1] == target)
			-- left;
		return new int[]{left, right};
    }

	private int searchBinary(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = ((right - left) >> 1) + left;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	// 二分法寻找target的左边界 且不包含target
	// 使用第一种二分 左闭右闭 [left, right]
	// 若leftBorder没有被赋值 说明target在数组范围的右边
	/*private int getLeftBorder(int[] nums, int target) {
		int leftBorder = -2;	// 记录左边界的值 且检验是否被赋值
		int left = 0;
		int right = nums.length -1;
		while (left <= right) {        // left == right 有意义
			int mid = ((right - left) >> 1) + left;		// 防止溢出
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
				leftBorder = right;
			}
		}
		return leftBorder;
	}

	// 二分查找寻找target的右边界 且不包含target
	// 使用第一种二分 左闭右闭[left, right]
	// 若rightBorder没有被赋值 说明target在数组范围的左边
	private int getRightBorder(int[] nums, int target) {
		int rightBorder = -2;		// 记录rightBorder是否被赋值 即是否有搜索到右边界
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {		// 左闭右闭 left==right 有意义
			int mid = ((right - left) >> 1) + left;		// 防止溢出
			if (nums[mid] > target) {
				// nums[mid] > target 说明目标值在 左区间[left, mid-1]
				right = mid - 1;
			} else {
				// nums[mid] <= target 说明右边界在右区间
				// 当 nums[mid] == target 时 对右边界进行更新 得到不包含target的右边界
				left = mid + 1;
				rightBorder = left;
			}
		}
		return rightBorder;
	}*/
}
//leetcode submit region end(Prohibit modification and deletion)

}