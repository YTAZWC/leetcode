package leetcode.editor.cn;


import java.util.*;

/**
 * 491.非递减子序列
 * @author 花木凋零成兰
 * @date 2024-03-08 14:24:38
 */
public class T_491_NonDecreasingSubsequences {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_491_NonDecreasingSubsequences().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>>	ans = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	Set<List<Integer>> hash = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
		backtracking(0, nums);	// 回溯函数
		return ans;
    }
	private void backtracking(int startIndex, int[] nums) {
		if (path.size() >= 2) {
			// System.out.println(path);
			if (!hash.contains(path)) {
				ArrayList<Integer> newPath = new ArrayList<>(path);
				ans.add(newPath);
				hash.add(newPath);
			}
		}
		for (int i = startIndex; i < nums.length; ++ i) {
			if (path.isEmpty()) {	// 初始时 子序列为空
				path.add(nums[i]);	// 直接添加元素
			} else {
				if (i != startIndex && nums[i] == nums[i-1])
					continue;	// 树层去重
				int pre = path.get(path.size()-1);
				if (nums[i] < pre) continue;	// 去除非递增元素
				path.add(nums[i]);	// 添加符合条件的数组元素
			}
			backtracking(i+1, nums);		// 继续递归遍历
			path.remove(path.size() - 1);	// 回溯
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}