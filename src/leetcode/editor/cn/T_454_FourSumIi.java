package leetcode.editor.cn;


import java.util.HashMap;

/**
 * 454.四数相加 II
 * @author 花木凋零成兰
 * @date 2023-12-13 12:00:07
 */
public class T_454_FourSumIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_454_FourSumIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		// 存储数组nums1和nums2各个元素和 且(key-> nums1[i]+nums2[j], value-> 出现次数)
		HashMap<Integer, Integer> sumHash = new HashMap<>();
		int ans = 0;	// 统计满足条件的元组数
		// 计算 nums1[i]+nums2[j] 并记录到sumHash中
		for (int i = 0; i < nums1.length; ++i) {
			for (int j = 0; j < nums2.length; ++j) {
				int x = nums1[i] + nums2[j];
				sumHash.put(x, sumHash.getOrDefault(x, 0) + 1);
			}
		}
		// 计算 nums3[k]+nums4[l] 并寻找符合条件的元组
		for (int k = 0; k < nums3.length; ++k) {
			for (int l = 0; l < nums4.length; ++l) {
				int y = nums3[k] + nums4[l];
				y = -y;		// 由x+y=0 得 此时应查询sumHash中是否有x = -y的key
				ans += sumHash.getOrDefault(y, 0);	// 存在则添加元组个数 不存在则默认添加0
			}
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}