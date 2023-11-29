package leetcode.editor.cn;


/**
 * 有序数组的平方
 * @author 花木凋零成兰
 * @date 2023-11-29 12:13:35
 */
public class T_977_SquaresOfASortedArray {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_977_SquaresOfASortedArray().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int[] sortedSquares(int[] nums) {
		int[] ans = new int[nums.length];	// 新数组 用于存储排好序后的元素
		int index = 0;	// 新数组索引
		int i = 0;		// 从分界处往前遍历的指针
		int j = 0;		// 从分界处往后遍历的指针
		int k = 0;
		// 寻找分界
		while (k < nums.length && nums[k] < 0)
			k++;
		i = k-1;
		j = k;
		// 对i和j指向的数组元素进行比较 并添加到数组中
		while (i >= 0 && j < nums.length) {
			if (nums[i]*nums[i] > nums[j]*nums[j]) {
				ans[index++] = nums[j]*nums[j];
				j++;
			} else {
				ans[index++] = nums[i]*nums[i];
				i--;
			}
		}
		// 将还未添加元素继续添加到新数组中
		while (i >= 0) {
			ans[index++] = nums[i]*nums[i];
			i --;
		}
		while (j < nums.length) {
			ans[index++] = nums[j]*nums[j];
			j ++;
		}

		return ans;
    }*/

	public int[] sortedSquares(int[] nums) {
		int[] ans = new int[nums.length];	// 新数组 用于存储排好序后的元素
		int index = nums.length-1;	// 新数组索引
		for (int i = 0, j = nums.length-1; i <= j;) {		// i等于j 保证双向指针相向遍历时相遇的点可以添加到新数组中
			if (nums[i]*nums[i] > nums[j]*nums[j]) {	// 选择先添加最大的值
				ans[index--] = nums[i]*nums[i];		// 逆序添加到新数组中
				i ++;
			} else {
				ans[index--] = nums[j]*nums[j];
				j --;
			}
		}

		return ans;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}