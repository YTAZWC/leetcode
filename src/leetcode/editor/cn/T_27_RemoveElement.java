package leetcode.editor.cn;


/**
 * 移除元素
 * @author 花木凋零成兰
 * @date 2023-11-27 16:04:50
 */
public class T_27_RemoveElement {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_27_RemoveElement().new Solution();
		 int[] nums = new int[]{2};
		 int len = solution.removeElement(nums, 3);
		 for (int i = 0; i < len; ++i) {
			 System.out.println(nums[i]);
		 }
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
		int i = nums.length-1;			// 用于遍历值不为val的数组元素
		int j = 0;			// 用于遍历值为val的数组元素
		while (j <= i) {
			while (j < nums.length && nums[j] != val) {
				j ++;
			}

			while (i >= 0 && nums[i] == val) {
				i --;
			}
			if (j > i) break;		// 防止最后一次交换 i<j 导致等于val的值重新回到新数组中
			// 进行数组元素交换
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
		}
		// 在循环最后一次j退出循环时 指针j指向了第一个等于val的数组元素的索引处 即为新数组长度
		return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}