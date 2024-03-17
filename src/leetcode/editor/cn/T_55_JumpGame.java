package leetcode.editor.cn;


/**
 * 55.跳跃游戏
 * @author 花木凋零成兰
 * @date 2024-03-17 11:50:33
 */
public class T_55_JumpGame {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_55_JumpGame().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
		int len = nums.length;
		if (len == 1) return true;	// 边界条件
		int maxLen = 0;	// 跳过的数组位置 可以到达的最大位置
		for (int i = 0; i < len; ++ i) {
			if (maxLen < i) {
				// 说明此时可到达的最远距离 无法移动到当前位置 即无法继续往下走
				return false;
			}
			maxLen = Math.max(maxLen, nums[i] + i);	// 更新可到达的最远位置
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}