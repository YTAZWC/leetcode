package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216.组合总和 III
 * @author 花木凋零成兰
 * @date 2024-03-05 13:16:21
 */
public class T_216_CombinationSumIii {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_216_CombinationSumIii().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
		backtracking(k, n, 1, 0);
		return ans;
    }
	private void backtracking(int k, int n, int startIndex, int count) {
		if (count == n && path.size() == k) {
			ans.add(new ArrayList<>(path));		// 保存符合题意的组合
			return ;	// 结束本层递归
		}
		for (int i = startIndex; i <= Math.min(n-count, 9); ++ i) {
			path.add(i);	// 尝试选择元素
			backtracking(k, n, i+1, count+i);	// 继续下一层递归
			path.remove(path.size()-1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}