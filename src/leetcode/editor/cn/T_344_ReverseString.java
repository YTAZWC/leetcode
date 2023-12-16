package leetcode.editor.cn;


/**
 * 344.反转字符串
 * @author 花木凋零成兰
 * @date 2023-12-16 22:16:59
 */
public class T_344_ReverseString {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_344_ReverseString().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
		int left = 0;	// 定义左指针
		int right = s.length - 1;	// 定义右指针
		while (left < right) {
			// 交换 左右指针指向的元素
			char ch = s[left];
			s[left] = s[right];
			s[right] = ch;
			// 移动左指针
			++ left;
			// 移动右指针
			-- right;
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}