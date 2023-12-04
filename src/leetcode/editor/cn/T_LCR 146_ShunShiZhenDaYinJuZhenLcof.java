package leetcode.editor.cn;


/**
 * 螺旋遍历二维数组
 * @author 花木凋零成兰
 * @date 2023-12-04 14:34:47
 */
class T_LCR_146_ShunShiZhenDaYinJuZhenLcof {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_LCR_146_ShunShiZhenDaYinJuZhenLcof().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralArray(int[][] array) {
		if(array.length == 0) 		// 处理异常情况 array=[] 时 直接返回
			return new int[0];

		int t = 0;		// 上边
		int b = array.length - 1;		// 下边
		int l = 0;		// 左边
		int r = array[0].length	- 1;	// 右边
		int s = (b+1)*(r+1);	// 总的数组元素个数
		int k = 0;		// 记录遍历到的数组元素个数
		int[] ans = new int[s];
		// 区间为 左闭右闭
		while (k < s) {
			// 上边 从左向右
			// k < s 保证循环过程中不会重复遍历数组
			for (int j = l; j <= r && k < s; ++j, ++k) {
				ans[k] = array[t][j];
			}
			++ t;		// 改边遍历完后 下次遍历下一行
			// 右边 从上向下
			for (int i = t; i <= b && k < s; ++i, ++k) {
				ans[k] = array[i][r];
			}
			-- r;
			// 下边 从右往左
			for (int j = r; j >= l && k < s; --j, ++k) {
				ans[k] = array[b][j];
			}
			-- b;
			// 左边 从下往上
			for (int i = b; i >= t && k < s; --i, ++k) {
				ans[k] = array[i][l];
			}
			++ l;
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}