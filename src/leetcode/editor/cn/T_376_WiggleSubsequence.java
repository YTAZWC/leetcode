package leetcode.editor.cn;


/**
 * 376.摆动序列
 * @author 花木凋零成兰
 * @date 2024-03-13 20:56:06
 */
public class T_376_WiggleSubsequence {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_376_WiggleSubsequence().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int wiggleMaxLength(int[] nums) {
		if (nums.length == 1) return 1;
		int preDiff = 0;	// 记录nums[i] - nums[i-1] 初始化为0 默认第一个数组元素前有平坡
		int curDiff = 0;	// 记录nums[i+1] - nums[i]
		int result = 1;		// 记录最长子序列的长度	默认最后一个元素在摆动序列中
		for (int i = 0; i < nums.length - 1; ++ i) {
			curDiff = nums[i+1] - nums[i];
			if ((preDiff >= 0 && curDiff < 0) || (preDiff <= 0 && curDiff > 0)) {
				++ result;
				preDiff = curDiff;	// 不实时更新preDiff 保证在单调性完全改变时 再更新 避免单调坡中的平坡
			}
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}