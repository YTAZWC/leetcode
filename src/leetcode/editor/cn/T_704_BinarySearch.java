package leetcode.editor.cn;


/**
 * 二分查找
 * @author 花木凋零成兰
 * @date 2023-11-25 18:08:28
 */
public class T_704_BinarySearch {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_704_BinarySearch().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;	// 避免 right+left超出int范围
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}