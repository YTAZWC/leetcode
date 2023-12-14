package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 * @author 花木凋零成兰
 * @date 2023-12-14 11:47:22
 */
public class T_15_ThreeSum {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_15_ThreeSum().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);	// 对数组元素进行排序
		for (int i = 0; i < nums.length-2; ++i) {	// 寻找元组的第一个数a
			if (i > 0 && nums[i] == nums[i-1]) {	// 跳过重复的数
				continue;
			}
			int a = nums[i];	// 找到元组的第一个数a

			if (a + nums[i+1] + nums[i+2] > 0)	// 因为数组按非递减排序
				break;	// 若此时数组中连续三个数相加结果大于0 则后续不存在别的数使得a+b+c=0成立
			if (a + nums[nums.length-2] + nums[nums.length-1] < 0)
				continue;	// 若此时a+数组中末尾两个最大的数结果小于0 则此时的a添加其他数依然会小于0

			// 寻找元组的第二个数b和第三个数c
			int j = i+1;
			int k = nums.length-1;
			while (j < k) {		// 相向双指针 遍历寻找
				int s = a + nums[j] + nums[k];
				if (s > 0) {	// 说明 c 的值过大
					-- k;		// 移动右指针 往前继续寻找 c 即让c减小
				} else if (s < 0) {
					++ j;		// 移动左指针 往后继续寻找 b
				} else {	// 找到符合条件的元组
					List<Integer> list = new ArrayList<>();
					list.add(a);
					list.add(nums[j]);
					list.add(nums[k]);
					ans.add(list);	// 将元组保存到返回值中
					// 移动左指针
					++ j;
					while (j < k && nums[j] == nums[j-1])	// 跳过重复的数 避免重复添加相同的元组
						++ j;
					// 移动右指针
					-- k;
					while (j < k && nums[k] == nums[k+1])	// 跳过重复的数 避免重复添加相同元组
						-- k;
				}
			}
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}