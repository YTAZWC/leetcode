package leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author 花木凋零成兰
 * @date 2023-11-23 02:28:30
 */
public class T_1_TwoSum {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_1_TwoSum().new Solution();

	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {

/*		// 创建哈希表存储数组元素
		HashMap<Integer, Integer> numHash = new HashMap<>();
		int n = nums.length;	// 记录数组长度
		int i = 0;
		int j = 0;
		// 将数组元素存储到哈希表中
		for (i = 0; i < n; ++i) {
			numHash.put(nums[i], i);
		}
		// 通过遍历数组元素，并查询哈希表找出对应的另一个整数
		for (i = 0; i < n; ++i) {
			int num = target - nums[i];
			if (numHash.containsKey(num) && numHash.get(num) != i) {
				j = numHash.get(num);
				break;
			}
		}
		return new int[]{i, j};*/

		// 方法2
		HashMap<Integer, Integer> numHash = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			int num = target - nums[i];
			if (numHash.containsKey(num)) {
				return new int[]{i, numHash.get(num)};
			} else {
				numHash.put(nums[i], i);
			}
		}
		return new int[0];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}