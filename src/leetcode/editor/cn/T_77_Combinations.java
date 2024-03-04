package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77.组合
 * @author 花木凋零成兰
 * @date 2024-03-04 16:41:30
 */
public class T_77_Combinations {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_77_Combinations().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<Integer>> ans;	// 存储组合的答案
	int num;	// 将n值 设为全局
	int ret;	// 将k值 设为全局
	public List<List<Integer>> combine(int n, int k) {
		ans = new ArrayList<>();
		num = n;
		ret = k;
		backtracking(1, new ArrayList<>());
		return ans;
    }
	private void backtracking(int s, List<Integer> arr) {

		if (arr.size() == ret) {
			ans.add(new ArrayList<>(arr));
			return ;
		}
		for (int i = s; i <= num-ret+arr.size()+1; ++ i) {
			arr.add(i);
			backtracking(i+1, arr);
			arr.remove(arr.size()-1);
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}