package leetcode.editor.cn;


/**
 * 比较含退格的字符串
 * @author 花木凋零成兰
 * @date 2023-11-28 22:27:20
 */
public class T_844_BackspaceStringCompare {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_844_BackspaceStringCompare().new Solution();
		 System.out.println(solution.backspaceCompare("bxj##tw", "bxo#j##tw"));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public boolean backspaceCompare(String s, String t) {
		return buildString(s).equals(buildString(t));
    }
	// 模拟字符串输入到空白的文本编辑器
	private String buildString(String s) {
		StringBuilder ans = new StringBuilder();
		int n = s.length();
		for (int i = 0; i < n; ++ i) {
			char ch = s.charAt(i);
			if (ch != '#') {	// 如果该字符是字母则输入
				ans.append(ch);
			} else {	// 若字符是'#'  则回退
				if (!ans.isEmpty())		// 不为空时需要回退
					ans.deleteCharAt(ans.length()-1);
			}
		}
		return ans.toString();
	}*/

	public boolean backspaceCompare(String s, String t) {
		int lenS = s.length() - 1;		// 字符串s的长度
		int lenT = t.length() - 1;		// 字符串t的长度
		int skipS = 0;		// 表示逆序遍历过程中 s有多少字符需要被删除
		int skipT = 0;		// 表示逆序遍历过程中 t有多少字符需要被删除

		while (lenS >= 0 || lenT >= 0) {
			// 逆序遍历 找出字符串s需要比较的字符
			while (lenS >= 0) {
				if (s.charAt(lenS) == '#') {
					// 若字符为回退符
					// 删除数目加一
					lenS --;
					skipS ++;
				} else {	// 若字符为普通字符
					if (skipS > 0) {	// 需要删除
						lenS --;
						skipS --;
					} else {	// 不需要删除则退出循环 进行比较
						break;
					}
				}
			}
			// 逆序遍历 找出字符串t需要比较的字符
			while (lenT >= 0) {
				if (t.charAt(lenT) == '#') {
					lenT --;
					skipT ++;
				} else {
					if (skipT > 0) {
						skipT --;
						lenT --;
					} else {
						break;
					}
				}
			}
			// 进行字符比较
			if (lenT >= 0 && lenS >= 0) {
				// 说明字符串均未遍历完 则判断此时指针指向字符是否相等
				if (s.charAt(lenS) != t.charAt(lenT)) {
					return false;
				}
			} else {
				// 当lenT<0 和 lenS<0 同时成立时 说明两个字符串是空串即相等
				if (lenT >= 0 || lenS >= 0) {
					// 若此时 字符串s或字符串t 中有未遍历完的字符串且另外一条字符串已为空 则说明两个字符串不等
					return false;
				}
			}
			lenS --;
			lenT --;
		}

		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}