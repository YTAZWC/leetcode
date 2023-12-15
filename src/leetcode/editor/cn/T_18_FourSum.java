package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18.四数之和
 * @author 花木凋零成兰
 * @date 2023-12-15 10:27:53
 */
public class T_18_FourSum {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_18_FourSum().new Solution();
		 int[] nums = new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000};
		 System.out.println(solution.fourSum(nums, 1000000000));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		int n = nums.length;	// 数组长度
		if (n < 4)		// 数组元素小于4 则不存在四元组
			return ans;
		Arrays.sort(nums);	// 对数组进行排序
		// 查找元组
		for (int i = 0; i < n-3; ++ i) {
			int a = nums[i];	// 元组第一个元素 a
			if (i > 0 && nums[i] == nums[i-1]) {	// 排除重复的元素a
				continue;
			}
			if ((long)a + nums[i+1] + nums[i+2] + nums[i+3] > target)
				break;	// 确定a后 进行剪枝
			if ((long)a + nums[n-3] + nums[n-2] + nums[n-1] < target)
				continue;	// 确定a后 进行剪枝
			for (int j = i+1; j < n-2; ++ j) {
				int b = nums[j];	// 元组第二个元素 b
				if (j > i+1 && nums[j] == nums[j-1]) {    // 排除重复的元素 b
					continue;
				}
				if ((long)a + b + nums[j+1] + nums[j+2] > target)
					break;	// 确定a和b后 进行剪枝
				if ((long)a + b + nums[n-2] + nums[n-1] < target)
					continue;	// 确定a和b后 进行剪枝
				// 双指针遍历 查找元素c和d
				int k = j+1;
				int l = n-1;
				while (k < l) {
					// 因为nums[i]的值为10^9 四数和可能会出现溢出 需要使用long来存储
					long s = (long)a + b + nums[k] + nums[l];
					if (s > target) {    // 四个元素和过大 说明d的值需要减小
						-- l;	// 右指针左移
					} else if (s < target) {	// 四个元素和过小 说明c的值需要增大
						++ k;	// 左指针右移
					} else {
						ans.add(Arrays.asList(a, b, nums[k], nums[l]));	// 将找到的元组记录到返回值
						// 移动左指针 并去重
						++ k;
						while (k < l && nums[k] == nums[k-1])
							++ k;
						// 移动右指针 并去重
						-- l;
						while (k < l && nums[l] == nums[l+1])
							-- l;
					}
				}
			}
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}