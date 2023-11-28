package leetcode.editor.cn;


/**
 * 移动零
 * @author 花木凋零成兰
 * @date 2023-11-28 15:03:49
 */
public class T_283_MoveZeroes {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_283_MoveZeroes().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 /*
    public void moveZeroes(int[] nums) {
		if (nums.length == 1)
			return ;  // 数组长度为1时不需要移动
		int fast;
		int slow = 0;
		// 记录数组元素不为0的数量 用于从数组后端重新将0赋值
		// 避免反复覆盖nums[fast] 快指针指向的值
		int count = 0;

		// 循环寻找第一个不为0的索引 避免数组前端不为0的元素重复赋值
		while (slow < nums.length && nums[slow] != 0) {
			++ slow;
			++ count;
		}

		// 说明数组中不含有为0的元素 不需要移动数组元素
		if (slow == nums.length) {
			return ;
		}
		// 慢指针指向的数组元素为0的索引处 快指针从下一个索引开始搜索不为0的数组元素
		fast = slow+1;

		while(fast < nums.length) {
			if (nums[fast] != 0) {
				nums[slow++] = nums[fast];
				count++;
			}
			++ fast;
		}
		if (count == 0) {	// 说明数组元素全为0 不需要移动
			return ;
		}
		count = nums.length-count;
		// 将0赋值给数组末尾
		for (int i = nums.length-1; i >= 0 && count > 0; -- i, -- count) {
			nums[i] = 0;
		}
    }*/

	public void moveZeroes(int[] nums) {
		if (nums.length == 1)
			return ;  // 数组长度为1时不需要移动
		int fast;
		int slow = 0;	// 遍历保存非0数组元素 并统计非0元素个数
		// 循环寻找第一个不为0的索引 避免数组前端不为0的元素重复赋值
		while (slow < nums.length && nums[slow] != 0) {
			++ slow;
		}
		// 说明数组中不含有为0的元素 不需要移动数组元素 直接返回
		if (slow == nums.length) {
			return ;
		}
		// 慢指针指向数组元素为0的索引处
		// 快指针从下一个索引开始搜索不为0的数组元素
		fast = slow+1;
		while(fast < nums.length) {
			if (nums[fast] != 0) {
				nums[slow++] = nums[fast];
			}
			++ fast;
		}
		// 进行移动后 若 slow==0 则说明数组元素均为0 不需要再进行重赋值为0
		if (slow == 0) return ;
		// 进行重复值为0
		while (slow < nums.length)
			nums[slow ++] = 0;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}