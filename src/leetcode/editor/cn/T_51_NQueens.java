package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51.N 皇后
 * @author 花木凋零成兰
 * @date 2024-03-10 09:53:34
 */
public class T_51_NQueens {
	 public static void main(String[] args) {
		 //测试代码
		 Solution solution = new T_51_NQueens().new Solution();
		 System.out.println(solution.solveNQueens(4));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	List<List<String>> ret = new LinkedList<>();
	List<String> path = new LinkedList<>();
	int[][] flag;	// 用于标记几个皇后导致某位置不能放置 当0个皇后时 即flag[i][j]=0
	boolean[][] ans;	// 记录放置皇后的位置
    public List<List<String>> solveNQueens(int n) {
		flag = new int[n][n];
		ans = new boolean[n][n];
		backtracking(0, n);
		return ret;
    }
	private void backtracking(int count, int n) {
		if (count == n) {
			// 找到符合题意的方案
			path.clear();	// 清除之前保存的方案
			for (int i = 0; i < n; ++i) {
				StringBuilder str = new StringBuilder();
				for (int j = 0; j < n; ++j) {
					if (ans[i][j])
						str.append('Q');
					else str.append('.');
				}
				path.add(str.toString());
			}
			ret.add(new ArrayList<>(path));
			return ;
		}
		for (int i = 0; i < n; ++ i) {
			if (flag[count][i] != 0)
				continue;	// 跳过不能放置皇后的位置
			doFlag(count, i, 1, n);	// 根据当前位置 对不能放置皇后的位置作标记
			ans[count][i] = true;	// 记录放置皇后的位置
			backtracking(count+1, n);
			ans[count][i] = false;	// 回溯
			doFlag(count, i, -1, n);
		}

	}
	// 根据皇后位置 做标记函数
	private void doFlag(int i, int j, int value, int n) {
		int k, l;
		// 标记行
		for (k = 0; k < n; ++ k)
			flag[i][k] += value;
		// 标记列
		for (k = 0; k < n; ++ k) {
			if (k == i) continue;	// 避免重复标记
			flag[k][j] += value;
		}
		// 当前位置到右下角
		k = i;	l = j;
		while (++k < n && ++l < n)
			flag[k][l] += value;
		// 当前位置到右上角
		k = i;	l = j;
		while (--k >= 0 && --l >= 0)
			flag[k][l] += value;
		// 当前位置到左下角
		k = i;	l = j;
		while (++k < n && --l >= 0)
			flag[k][l] += value;
		// 当前位置到左上角
		k = i;	l = j;
		while (--k >= 0 && ++l < n)
			flag[k][l] += value;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}