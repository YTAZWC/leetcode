package leetcode.editor.cn;


/**
 * 37.解数独
 * @author 花木凋零成兰
 * @date 2024-03-10 11:49:08
 */
public class T_37_SudokuSolver {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_37_SudokuSolver().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	boolean[][] rows;	// 记录第i行 已放的数字
	boolean[][] cols;	// 记录第j列 已存放的数字
	boolean[][] blocks;	// 记录第几个方块 已存放的数字; 方块序号为 从左到右 从上到下
    public void solveSudoku(char[][] board) {
		// 初始化 rows、cols、blocks
		rows = new boolean[board.length][board[0].length + 1];
		cols = new boolean[board.length][board[0].length + 1];
		blocks = new boolean[board.length][board[0].length + 1];
		init(board);	// 对三个记录数组进行初始化
		backtracking(board);
    }
	private void init(char[][] board) {
		// 初始化
		for (int i = 0; i < board.length; ++ i) {
			for (int j = 0; j < board[0].length; ++ j) {
				if (board[i][j] != '.') {
					rows[i][board[i][j] - '0'] = true;	// 记录第i行
					blocks[getBlock(i, j)][board[i][j] - '0'] = true;	// 记录第几个3*3宫内
				}
				if (board[j][i] != '.') {
					cols[i][board[j][i] - '0'] = true;	// 记录第i列
				}
			}
		}
	}
	private boolean backtracking(char[][] board) {
		for (int i = 0; i < board.length; ++ i) {
			for (int j = 0; j < board[0].length; ++ j) {
				if (board[i][j] == '.') {
					for (int k = 1; k <= 9; ++ k) {
						if (isValid(i, j, k)) {
							board[i][j] = (char) (k+'0');
							rows[i][k] = true;
							cols[j][k] = true;
							blocks[getBlock(i, j)][k] = true;
							if (backtracking(board))
								return true;
							board[i][j] = '.';
							rows[i][k] = false;
							cols[j][k] = false;
							blocks[getBlock(i, j)][k] = false;
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	private boolean isValid(int i, int j, int k) {
		return !(rows[i][k] || cols[j][k] || blocks[getBlock(i, j)][k]);
	}
	private int getBlock(int i, int j) {	// 根据方块坐标 获取其位于第几个3*3宫内
		return 3 * (i/3) + j/3;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}