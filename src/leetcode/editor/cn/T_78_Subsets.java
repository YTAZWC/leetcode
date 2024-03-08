package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;

/**
 * 78.子集
 * @author 花木凋零成兰
 * @date 2024-03-08 11:46:01
 */
public class T_78_Subsets {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_78_Subsets().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
		ans.add(new ArrayList<>(path));	// 获取空集
		backtracking(0, nums);
		return ans;
    }
	private void backtracking(int startIndex, int[] nums) {
		if (!path.isEmpty() && path.size() <= nums.length) {
			ans.add(new ArrayList<>(path));
		}
		for (int i = startIndex; i < nums.length; ++ i) {
			path.add(nums[i]);
			backtracking(i+1, nums);
			path.remove(path.size()-1);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}