package leetcode.editor.cn;


/**
 * 509.斐波那契数
 * @author 花木凋零成兰
 * @date 2024-03-31 11:51:57
 */
public class T_509_FibonacciNumber {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_509_FibonacciNumber().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int fib(int n) {
//		if (n == 0 || n == 1)
//			return n;
//		int[] dp = new int[n+1];
//		dp[0] = 0;
//		dp[1] = 1;
//		for (int i = 2; i <= n; ++ i) {
//			dp[i] = dp[i-1] + dp[i-2];
//		}
//		return dp[n];
//    }

	public int fib(int n) {
		if (n == 0 || n == 1)
			return n;
		int ans = 0;
		int a = 0, b = 1;	// 用于表示推导下一层状态的两个状态
		for (int i = 2; i <= n; ++ i) {
			ans = a + b;	// 状态转移
			// 更新两个状态
			a = b;
			b = ans;
		}
		return ans;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}