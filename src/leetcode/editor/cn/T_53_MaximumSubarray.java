package leetcode.editor.cn;


/**
 * 53.最大子数组和
 * @author 花木凋零成兰
 * @date 2024-03-15 11:40:49
 */
public class T_53_MaximumSubarray {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_53_MaximumSubarray().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
		int result = Integer.MIN_VALUE;
		int count = 0;
        for (int num : nums) {
            count += num;
            if (count > result) // 时刻更新最大和
				result = count;
            if (count < 0)
				count = 0;	// 当连续子数组和小于0时 重置连续和为0
        }
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}