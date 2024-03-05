package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * 39.组合总和
 * @author 花木凋零成兰
 * @date 2024-03-05 15:42:39
 */
public class T_39_CombinationSum {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_39_CombinationSum().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		backtracking(target, candidates, 0);
		return ans;
    }
	private void backtracking(int target, int[] candidates, int startIndex) {
		if (target == 0) {
			ans.add(new ArrayList<>(path));
			return ;
		}
		for (int i = startIndex; i < candidates.length; ++ i) {
			if (candidates[i] > target) continue;	// 若不符合题意 则跳过该数
			path.add(candidates[i]);	// 选取符合题意元素
			backtracking(target-candidates[i], candidates, i);
			path.remove(path.size() - 1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}