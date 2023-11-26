package leetcode.editor.cn;


/**
 * 搜索插入位置
 * @author 花木凋零成兰
 * @date 2023-11-25 23:10:35
 */
public class T_35_SearchInsertPosition {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_35_SearchInsertPosition().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
		// 使用第一种二分，左闭右闭
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int mid = ((right - left) >> 1) + left;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				// 查找到对应位置 直接返回
				return mid;
			}
		}
		// 未找到对应位置，返回目标值按顺序插入的位置
		// 在最后一次和left有关的查找中 mid指针指在刚好小于目标值的索引处
		// 因此left = mid+1 刚好将left指针指在target按顺序插入的位置处
		return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}