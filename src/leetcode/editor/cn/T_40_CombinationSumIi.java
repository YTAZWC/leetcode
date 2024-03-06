package leetcode.editor.cn;


import java.util.*;

/**
 * 40.组合总和 II
 * @author 花木凋零成兰
 * @date 2024-03-06 21:36:05
 */
public class T_40_CombinationSumIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_40_CombinationSumIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans = new ArrayList<>();	// 保留符合题意的元素组合
	List<Integer> path = new ArrayList<>();		// 记录选取的元素组合
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates); // 对集合进行排序 便于去重
		backtracking(candidates, target, 0);
		return ans;
    }
	private void backtracking(int[] candidates, int target, int startIndex) {
		if (target == 0) {    // 说明已经找到符合题意的组合
			ans.add(new ArrayList<>(path));
			return ;	// 结束循环
		}
		for (int i = startIndex; i < candidates.length; ++i) {
			if (candidates[i] > target) continue;	// 剪枝
			if (i > startIndex && candidates[i] == candidates[i-1])	// i > startIndex 保证是在树层去重
				continue;	// 避免出现重复的组合 在树层去重
			path.add(candidates[i]);	// 选取元素
			backtracking(candidates, target-candidates[i], i+1);	// 继续递归选取
			path.remove(path.size()-1);	// 回溯
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}