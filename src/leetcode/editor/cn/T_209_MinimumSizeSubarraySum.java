package leetcode.editor.cn;


/**
 * 长度最小的子数组
 * @author 花木凋零成兰
 * @date 2023-11-30 12:43:07
 */
public class T_209_MinimumSizeSubarraySum {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_209_MinimumSizeSubarraySum().new Solution();
		 System.out.println(solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int minSubArrayLen(int target, int[] nums) {
		int sum = 0;
		int min = nums.length;
		int s = 0;
		int e = 0;
		// 判断是否存在符合条件的子数组
		while (e < nums.length && sum < target) {
			sum += nums[e++];
		}
		if (e == nums.length) {		// 当子数组和父数组相等时
			if (sum < target)
				return 0;		// 数组和依然小于目标值 则不存在符合条件的子数组
		}
		// 找到满足条件的第一个子数组 [s, e)
		min = Math.min(min, e-s);
		// 继续寻找其他子数组 并寻找长度最小的子数组
		while (e < nums.length) {
			// 将指针e指向的数组元素加入到子数组中
			sum = sum + nums[e];	// 此时 sum > target 肯定成立 且子数组变为[s, e]
			// 对子数组从左往右进行缩短
			while (s < e && sum >= target) {
				sum -= nums[s];		// 将s指向的元素移出子数组
				s ++;
			}
			// 进行回退 保证此时sum刚好满足 sum>=target
			s -= 1;
			sum += nums[s];
			// 此时子数组[s, e]刚好满足条件
			min = Math.min(min, e-s+1);
			e++;
		}
		// 此时子数组为[s, e)
		// 对子数组进行进一步缩减 避免因为指针e指向数组末尾导致无法对指针s进行移动的情况
		while (s < e && sum >= target) {
			sum -= nums[s];
			s ++;
		}
		// 回退 保证子数组[s, e)满足条件
		s-=1;
		sum += nums[s];
		min = Math.min(min, e-s);

		return min;
    }*/
	public int minSubArrayLen(int target, int[] nums) {
		int sum = 0;				// 统计子数组元素和
		int min = nums.length+1;	// 子数组最大长度为nums.length
		int s = 0;		// 指向子数组起始位置
		int e = 0;		// 指向子数组末尾位置
		while (e < nums.length) {
			sum += nums[e];		// 末尾指针添加元素到子数组中
			while (sum >= target) {
				min = Math.min(min, e - s + 1);		// 此时区间为[s,e] 更新最小长度
				// 此时含有s指针指向元素的子数组已经计算过长度 则
				sum -= nums[s];		// 将起始指针指向元素踢出子数组
				s ++;		// 更新区间起始位置
			}
			e++;
		}
		if (min == nums.length + 1) return 0;	// 若不存在则返回 0
		return min;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}