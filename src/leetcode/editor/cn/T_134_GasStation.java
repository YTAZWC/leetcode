package leetcode.editor.cn;


/**
 * 134.加油站
 * @author 花木凋零成兰
 * @date 2024-03-20 10:54:16
 */
public class T_134_GasStation {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_134_GasStation().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
		int currentSum = 0;	// 记录当前区间的和
		int totalSum = 0;	// 记录总耗费的油和获得的油的差
		int start = 0;	// 记录 一圈起始索引
		for (int i = 0; i < gas.length; ++ i) {
			currentSum += gas[i] - cost[i];
			totalSum += gas[i] - cost[i];	// 统计总获得的油与耗费的油的差
			if (currentSum < 0) {	// 出现这段区间和小于0 则从下一个索引继续开始求和
				start = i+1;	// 更新 一圈的起始索引
				currentSum = 0;	// 重置为0 从索引i+1开始继续求和
			}
		}
		if (totalSum < 0)	// 如果总和小于0 则不可能从哪个点开始成功走一圈
			return -1;	// 直接返回-1即可
		return start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}