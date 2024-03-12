package leetcode.editor.cn;


import java.util.Arrays;

/**
 * 455.分发饼干
 * @author 花木凋零成兰
 * @date 2024-03-12 16:34:19
 */
public class T_455_AssignCookies {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_455_AssignCookies().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
		int childCount = 0;	// 记录可满足孩子的数目
		Arrays.sort(g);	// 对孩子胃口 按从大到小 排序
		Arrays.sort(s);	// 对饼干胃口 按从大到小 排序
		int i = g.length-1;	// 从最大的胃口的孩子开始枚举
		int j = s.length-1;	// 从最大尺寸的饼干开始枚举
		while (j >= 0 && i >= 0) {
            if (s[j] >= g[i]) {
				// 说明此时
				++ childCount;	// 满足孩子数目增加
				-- j;	// 换新的饼干
            }
            -- i;	// 换下一个孩子
        }
		return childCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}