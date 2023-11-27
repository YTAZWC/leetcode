package leetcode.editor.cn;


/**
 * 有效的完全平方数
 * @author 花木凋零成兰
 * @date 2023-11-27 12:35:46
 */
public class T_367_ValidPerfectSquare {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_367_ValidPerfectSquare().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
		if (num == 1)
			return true;	// 因为 1 是一个完全平方数 直接返回true
		int start = 1;
		int end = num / 2;
		int ans = 0;
		while (start <= end) {		// 使用左闭右闭的二分写法
			int mid = ((end - start) >> 1) + start;
			if ((long)mid*mid <= num) {
				// 当mid*mid == num 时 保存算术平方根
				ans = mid;
				start = mid + 1;
			} else {
				// 算术平方根在左区间 则将右端点缩小
				end = mid - 1;
			}
		}
		return ans*ans == num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}