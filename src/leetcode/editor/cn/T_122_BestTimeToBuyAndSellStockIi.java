package leetcode.editor.cn;


/**
 * 122.买卖股票的最佳时机 II
 * @author 花木凋零成兰
 * @date 2024-03-16 10:26:54
 */
public class T_122_BestTimeToBuyAndSellStockIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_122_BestTimeToBuyAndSellStockIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int maxProfit(int[] prices) {
//		int profitCount = 0;	// 统计多次买卖所得利润
//		int profit = 0;		// 记录单次买卖所得利润
//		for (int i = 0; i < prices.length-1; ++ i) {
//			if (profit == 0 && prices[i] < prices[i+1]) {	// 当未开始买卖时 尝试购买最小股票
//				profit -= prices[i];
//				if (prices[i] == 0) {	// 若买入股票花费为0 标记为已购买
//					profit -= 1;
//					profitCount += 1;
//				}
//			}
//			if (profit < 0 && prices[i] > prices[i+1]) {	// 若此时已买入股票 处于股票最大值时 卖出
//				profitCount += profit + prices[i];
//				profit = 0;
//			}
//		}
//		if (profit < 0)	// 若股票还在手里 说明股票在最后一天处于最大值 则卖出
//			profitCount += profit + prices[prices.length-1];
//		return profitCount;
//    }
	public int maxProfit(int[] prices) {
		int len = prices.length;
		int profitCount = 0;	// 统计多次买卖所得利润
		for (int i = 1; i < len; ++ i) {
			if (prices[i] > prices[i-1]) {
				// 说明当前股票价格大于昨天股票价格 可以昨天买入 再今天卖出
				profitCount += prices[i] - prices[i-1];
			}
		}
		return profitCount;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}