package leetcode.editor.cn;


/**
 * 42.接雨水
 * @author 花木凋零成兰
 * @date 2024-07-27 21:42:05
 */
public class T_42_TrappingRainWater {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_42_TrappingRainWater().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// 双指针
    public int trap(int[] height) {
		// 初始化
		int ans = 0;
		// 左、右指针 分别指向最左边界、最右边界
		int left = 0, right = height.length-1;
		// 左边界最大值
		int leftMax = 0;
		// 右边界最大值
		int rightMax = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				// 若左边界高度低于右边界高度 则说明凹槽高度以左边界为准
				if (height[left] > leftMax) {
					// 当此时左边界高度大于 左边界最大值时 无法形成凹槽 所以不计算雨水量
					leftMax = height[left];
				} else {
					// 左边界高度低于 最大值 则说明该处可以接到雨水 计算雨水量
					ans += leftMax - height[left];
				}
				// 移动左边界
				++ left;
			} else {
				if (height[right] > rightMax) {
					rightMax = height[right];
				} else {
					ans += rightMax - height[right];
				}
				-- right;
			}
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}