package leetcode.editor.cn;


/**
 * 11.盛最多水的容器
 * @author 花木凋零成兰
 * @date 2024-07-26 23:05:21
 */
public class T_11_ContainerWithMostWater {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_11_ContainerWithMostWater().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
		// 最大水量
		int area = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			area = Math.max(area, Math.min(height[left], height[right]) * (right-left));
			if (height[left] > height[right]) {
				-- right;
			} else {
				++ left;
			}
		}
		return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}