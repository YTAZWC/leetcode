package leetcode.editor.cn;


import java.util.HashMap;

/**
 * 水果成篮
 * @author 花木凋零成兰
 * @date 2023-12-01 12:52:21
 */
public class T_904_FruitIntoBaskets {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_904_FruitIntoBaskets().new Solution();
		 System.out.println(solution.totalFruit(new int[]{1, 1, 1}));
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalFruit(int[] fruits) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int s = 0;	// 记录装进篮子水果的起始位置
		int maxNum = -1;	// 计算收集水果的最大数目
		// int sum = 0;		// 统计装进篮子的水果数目
		for (int e = 0; e < fruits.length; ++ e) {
			// 摘下水果 并记录水果类型 保存水果数量
			hashMap.put(fruits[e], hashMap.getOrDefault(fruits[e], 0) + 1);
			// sum ++;
			while (hashMap.size() >= 3) {
				// 水果数量种类超过2 则将放弃左边的水果
				hashMap.put(fruits[s], hashMap.get(fruits[s]) - 1);
				if (hashMap.get(fruits[s]) == 0) {		// 不含有该水果类型时 将该水果类型弹出
					hashMap.remove(fruits[s]);
				}
				// sum --;
				s ++;
			}
			// 更新收集的水果的最大数目
            maxNum = Math.max(maxNum, e-s+1);
        }
		return maxNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}