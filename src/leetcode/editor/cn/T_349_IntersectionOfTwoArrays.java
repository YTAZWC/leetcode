package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * 349.两个数组的交集
 * @author 花木凋零成兰
 * @date 2023-12-11 21:18:51
 */
public class T_349_IntersectionOfTwoArrays {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_349_IntersectionOfTwoArrays().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		int[] hash = new int[1001];		// 哈希数组
		int[] ans = new int[nums1.length];	// 存储交集
		for (int number: nums1) {	// 统计数组nums1中的元素
			++ hash[number];
		}
		int k = 0;	// ans数组的索引
		for (int number: nums2) {    // 遍历数组nums2 寻找交集中的元素
			if (hash[number] > 0) {
				ans[k++] = number;
				hash[number] = -1;	// 更新哈希数组中对应的值 表示交集中不在需要该元素
			}
		}
		int[] anss = new int[k];
		// 数组复制	arraycopy(源数组, 源数组中的起始位置, 目标数组, 目标数组的起始位置, 复制的长度)
        System.arraycopy(ans, 0, anss, 0, k);
		return anss;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}