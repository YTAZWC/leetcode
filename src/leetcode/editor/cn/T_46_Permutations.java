package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 * @author 花木凋零成兰
 * @date 2024-03-09 10:29:41
 */
public class T_46_Permutations {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_46_Permutations().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<Integer> path = new ArrayList<>();	// 存储排列情况
	List<List<Integer>> ans = new ArrayList<>();	// 题目返回结果
	boolean[] flag = new boolean[7];	// 标记某元素是否已在排列中
    public List<List<Integer>> permute(int[] nums) {
		backtracking(nums);
		return ans;
    }
	private void backtracking(int[] nums) {
		if (path.size() == nums.length) {
			ans.add(new ArrayList<>(path));
			return ;
		}
		for (int i = 0; i < nums.length; ++ i) {
			if (flag[i]) continue;	// 排除路径中出现重复的元素
			path.add(nums[i]);
			flag[i] = true;	// 标记某元素已在排列中
			backtracking(nums);	// 继续递归
			flag[i] = false;	// 回溯
			path.remove(path.size() - 1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}