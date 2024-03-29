package leetcode.editor.cn;


/**
 * 738.单调递增的数字
 * @author 花木凋零成兰
 * @date 2024-03-29 14:14:18
 */
public class T_738_MonotoneIncreasingDigits {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_738_MonotoneIncreasingDigits().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int monotoneIncreasingDigits(int n) {
//		if (n == 0) return n;
//		String str = String.valueOf(n);	// 将其转化为字符串
//		int len = str.length();	// 获取整数n的位数
//		int[] nums = new int[len];	// 存储n的对应位上的值
//		for (int i = 0; i < len; ++ i) {	// 字符串转化为整型数组
//			nums[i] = str.charAt(i) - '0';
//		}
//
//		for (int i = 0; i < len; ++ i) {
//			boolean flag = true;	// 判断当前的整数数组 是否单调递增
//			for (int j = 1; j < len; ++ j) {
//				if (nums[j] < nums[j-1]) {	// 若当前位小于上一位
//					nums[j-1] -= 1;	// 上一位减一
//					while (j < len) {	// 后续位 全部变成9
//						nums[j] = 9;
//						++ j;
//					}
//					flag = false;	// 表示不单调递增
//					break;
//				}
//			}
//			if (flag) break;
//		}
//		int ans = 0;	// 将已经确定的递增数组 转化为整数
//		for (int i = 0; i < len; ++ i) {
//			ans = ans*10 + nums[i];
//		}
//		return ans;
//	}

	public int monotoneIncreasingDigits(int n) {
		if (n == 0) return n;
		String str = String.valueOf(n);	// 将其转化为字符串
		int len = str.length();	// 获取整数n的位数
		int[] nums = new int[len];	// 存储n的对应位上的值
		for (int i = 0; i < len; ++ i) {	// 字符串转化为整型数组
			nums[i] = str.charAt(i) - '0';
		}
		for (int i = len-1; i > 0; --i) {	// 从后往前遍历数组
			if (nums[i] < nums[i-1]) {	// 若当前位小于前一位
				nums[i-1] -= 1;	// 前一位减一
				for (int j = i; j < len; ++ j)
					nums[j] = 9;
			}
		}
		int ans = 0;	// 将已经确定的递增数组 转化为整数
		for (int i = 0; i < len; ++ i) {
			ans = ans*10 + nums[i];
		}
		return ans;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}