package leetcode.editor.cn;


/**
 * 删除有序数组中的重复项
 * @author 花木凋零成兰
 * @date 2023-11-27 21:24:02
 */
public class T_26_RemoveDuplicatesFromSortedArray {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_26_RemoveDuplicatesFromSortedArray().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
		// 使用快慢指针 保持元素的相对顺序一致
		int slow = 1;	// 从索引为1开始 新数组肯定包含旧数组的第一个元素
		// int val = nums[0];	// 保留数组第一个元素的值进行 用于判断是否有重复项
		for (int fast = 1; fast < nums.length; ++fast) {
			if (nums[fast] != nums[slow-1]) {
				// 出现不重复项 保存到新数组中 并更新重复值
				// val = nums[fast];
				if (fast-slow > 0)
					nums[slow] = nums[fast];
				slow ++;
			}
		}
		// 再保存新数组最后一个元素后 slow指针值刚好为新数组的元素个数
		return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}