package leetcode.editor.cn;


/**
 * 860.柠檬水找零
 * @author 花木凋零成兰
 * @date 2024-03-23 12:25:52
 */
public class T_860_LemonadeChange {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_860_LemonadeChange().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean lemonadeChange(int[] bills) {
		int a = 0;	// 记录5美元的钞票数目
		int b = 0;	// 记录10美元的钞票数目
		int c = 0;	// 记录20美元的钞票数目
        for (int bill : bills) {
            if (bill == 5) {
                a += 1;    // 5美元钞票不需要找零
            } else if (bill == 10) {
                if (a == 0) // 无法正确找零
                    return false;
                a -= 1;
                b += 1;
            } else {
                if (b > 0 && a > 0) {    // 存在10美元时 先使用10美元
                    a -= 1;
                    b -= 1;
                } else if (a >= 3) {    // 不存在10美元时 只能使用3张5美元进行找零
                    a -= 3;
                } else    // 其余情况 无法正确找零
                    return false;
                c += 1;
            }
        }
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}