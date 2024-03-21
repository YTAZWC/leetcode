package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 135.分发糖果
 * @author 花木凋零成兰
 * @date 2024-03-21 11:28:02
 */
public class T_135_Candy {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_135_Candy().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
		int len = ratings.length;
		int[] candy = new int[len];
        Arrays.fill(candy, 1);	// 保证每个孩子至少分配到1个糖果
		// 右孩子与左孩子比较 从左到右
		for (int i = 1; i < len; ++ i) {
			if (ratings[i] > ratings[i-1]) {
				candy[i] = candy[i-1] + 1;
			}
		}
		// 左孩子比较右孩子 从右到左
		for (int i = len-2; i >= 0; --i) {
			if (ratings[i] > ratings[i+1]) {
				candy[i] = Math.max(candy[i], candy[i+1] + 1);
			}
		}
		// 计算出分发的糖果后 计算总的糖果数量
		int sum = 0;
		for (int i : candy) {
			sum += i;
		}
		return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}