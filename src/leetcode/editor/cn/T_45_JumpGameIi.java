package leetcode.editor.cn;


/**
 * 45.跳跃游戏 II
 * @author 花木凋零成兰
 * @date 2024-03-18 10:29:04
 */
public class T_45_JumpGameIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_45_JumpGameIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
		int len = nums.length;
		int count = 0;	// 统计最小跳跃次数
		int preLen = 0;	// 记录每次跳跃的极限最远范围
		int maxLen = 0;	// 记录可跳跃的最大距离
		for (int i = 0; i < len-1; ++ i) {
			maxLen = Math.max(maxLen, nums[i] + i);
			if (i == preLen) {	// 当移动到上次跳跃最远距离 依旧未达到终点时
				preLen = maxLen;	// 更新这次跳跃最远距离
				++count;	// 跳跃次数增加
			}
			if (preLen >= len-1) break;
		}
		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}