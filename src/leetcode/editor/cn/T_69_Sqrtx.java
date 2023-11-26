package leetcode.editor.cn;


/**
 * x 的平方根 
 * @author 花木凋零成兰
 * @date 2023-11-26 21:44:12
 */
public class T_69_Sqrtx {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_69_Sqrtx().new Solution();
		 System.out.println(solution.mySqrt(2147395599));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
		if (x == 0 || x == 1) 	// 若x为1或2则算术平方根为x本身直接返回即可
			return x;
		// 当 x >= 2时 由算数平方根的性质可以得出 x的算术平方根a 一定 < x/2
		int end = x / 2;
		// 使用二分来搜索
		int start = 1;
		while (start < end) {
			int mid = ((end - start) >> 1) + start;
			if ((long)mid * mid > x) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		if (start*start > x) start -= 1;
		return start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}