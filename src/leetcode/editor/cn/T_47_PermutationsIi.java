package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * 47.全排列 II
 * @author 花木凋零成兰
 * @date 2024-03-09 10:52:14
 */
public class T_47_PermutationsIi {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_47_PermutationsIi().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans = new ArrayList<>();	// 答案集
	List<Integer> path = new ArrayList<>();	// 记录排列
	boolean[] flag = new boolean[9];	// 标记某元素是否已在排列中
    public List<List<Integer>> permuteUnique(int[] nums) {
		backtracking(nums);
		return ans;
    }
	private void backtracking(int[] nums) {
		if (path.size() == nums.length) {
			ans.add(new ArrayList<>(path));
			return ;
		}
		boolean[] used = new boolean[21];
		for (int i = 0; i < nums.length; ++ i) {
			if (flag[i] || used[nums[i]+10])
				continue;	// 避免树层重复 以及重复添加某元素到排列中
			used[nums[i]+10] = true;
			path.add(nums[i]);
			flag[i] = true;
			backtracking(nums);
			flag[i]	= false;	// 回溯
			path.remove(path.size() - 1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}