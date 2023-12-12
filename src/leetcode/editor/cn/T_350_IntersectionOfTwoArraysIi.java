package leetcode.editor.cn;


/**
 * 350.两个数组的交集 II
 * @author 花木凋零成兰
 * @date 2023-12-12 11:23:15
 */
public class T_350_IntersectionOfTwoArraysIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_350_IntersectionOfTwoArraysIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
		int[] hash = new int[1001];		// 哈希数组
		int[] ans = new int[nums1.length];	// 预返回结果数组
		int k = 0;	// 记录交集的元素个数
		for (int num: nums1) {	// 记录数组nums1中的元素及其数量
			++ hash[num];
		}
		for (int num: nums2) {  // 遍历数组nums2寻找交集中的元素
			if (hash[num] > 0) {
				ans[k++] = num;		// 将交集中的元素保存到返回数组中
				-- hash[num];		// 保存一个交集元素 则记录该元素的数目-1
			}
		}
		// 对返回结果进行处理
		int[] anss = new int[k];
		for (int i = 0; i < k; ++i)
			anss[i] = ans[i];
		return anss;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}