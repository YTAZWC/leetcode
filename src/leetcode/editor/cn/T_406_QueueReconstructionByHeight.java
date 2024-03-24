package leetcode.editor.cn;


import java.util.*;

/**
 * 406.根据身高重建队列
 * @author 花木凋零成兰
 * @date 2024-03-24 12:14:59
 */
public class T_406_QueueReconstructionByHeight {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_406_QueueReconstructionByHeight().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];		// 若身高相等 则按前面要几个更高的数目升序排
			} else return b[0] - a[0];	// 按身高降序排列
		});
		// System.out.println(Arrays.deepToString(people));	// 检验排序结果
		List<int[]> result = new ArrayList<>();	// 重新按照ki进行排列
        for (int[] person : people) {
            result.add(person[1], person);	// 若要求前面有几个更高的人 则插入第几个位置
        }
		return result.toArray(new int[0][]);	// 将符合题意的列表转化为数组
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}