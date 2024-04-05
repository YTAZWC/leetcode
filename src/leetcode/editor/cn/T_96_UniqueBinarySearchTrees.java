package leetcode.editor.cn;


/**
 * 96.不同的二叉搜索树
 * @author 花木凋零成兰
 * @date 2024-04-05 10:35:41
 */
public class T_96_UniqueBinarySearchTrees {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_96_UniqueBinarySearchTrees().new Solution();
		 System.out.println(solution.numTrees(3));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
		// dp[i]的含义：由i个连续整数节点可以组成dp[i]种不同的二叉搜索树
		int[] dp = new int[n+1];	// 状态转移方程为：dp[i] += dp[j] * dp[i-j-1]
		// 初始化dp
		dp[0] = 1;	// 空树 也算是一种组成的二叉搜索树
		dp[1] = 1;
		for (int i = 2; i <= n; ++ i) {
			for (int j = 0; j < i; ++ j) {
				dp[i] += dp[j] * dp[i-j-1];
			}
		}
		return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}