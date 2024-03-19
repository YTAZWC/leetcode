package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 1005.K 次取反后最大化的数组和
 * @author 花木凋零成兰
 * @date 2024-03-19 15:46:34
 */
public class T_1005_MaximizeSumOfArrayAfterKNegations {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_1005_MaximizeSumOfArrayAfterKNegations().new Solution();
		 System.out.println(solution.largestSumAfterKNegations(new int[]{-4,-2,-3}, 4));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
		Arrays.sort(nums);	// 对数组进行从小到大排序
		int index = 0;	// 确定需要反转的数组元素索引
		int len = nums.length;
		for (int i = 1; i <= k; ++i) {	// 进行反转
			if (index == len)	// 保证反转的过程中 不越界
				-- index;
			if (nums[index] > 0) {	// 当index此时指向的数组元素大于0时 说明前面元素均大于0
				if (index != 0) {	// 若数组大于0的元素不是第一个
					if (nums[index-1] < nums[index])	// 则判断前一个是否小于当前index指向的元素
						index = index-1;	// 若前一个元素更小 则移动index 对更小的元素进行反转
				}
				k = (k-i+1) % 2;	// 计算当前还需反转元素的次数
				if (k == 1) nums[index] = -nums[index];	// 若剩余次数为奇数 则再反转一次
				break;
			} else if (nums[index] == 0) {	// 当index指向元素为0时 说明index前和index后元素均大于0
				break;	//  只需重复反转此时为0的元素即可得到最大可能值 0反转无数次为0 即直接结束反转
			} else {
				nums[index] = - nums[index];	// 若此时index指向负数 反转即可
				++ index;	// 继续尝试反转下一个元素
			}
		}
		int ans = 0;
		for (int num : nums) {	// 对反转后的数组进行求和
			ans += num;
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}