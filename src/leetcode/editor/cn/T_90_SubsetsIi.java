package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90.子集 II
 * @author 花木凋零成兰
 * @date 2024-03-08 13:55:09
 */
public class T_90_SubsetsIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_90_SubsetsIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);	// 对集合进行排序 便于树层去重
		backtracking(0, nums);
		return ans;
    }
	private void backtracking(int startIndex, int[] nums) {
		ans.add(new ArrayList<>(path));	// 保存每个节点的结果

		for (int i = startIndex; i < nums.length; ++ i) {
			if (i != startIndex && nums[i] == nums[i-1])
				continue;	// 树层去重
			path.add(nums[i]);	// 添加元素
			backtracking(i+1, nums);	// 继续递归
			path.remove(path.size() - 1);	// 回溯
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}