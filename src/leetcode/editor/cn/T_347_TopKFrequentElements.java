package leetcode.editor.cn;


import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 347.前 K 个高频元素
 * @author 花木凋零成兰
 * @date 2023-12-26 10:04:22
 */
public class T_347_TopKFrequentElements {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_347_TopKFrequentElements().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int[] topKFrequent(int[] nums, int k) {
//		HashMap<Integer, Integer> hashMap = new HashMap<>();
//		for (int num : nums) {	// 使用哈希表对数组元素个数进行统计
//			hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
//		}
//		PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
//			return o2[1] - o1[1];
//		}));
//		hashMap.forEach((key, value) -> {	// 将哈希表元素保存到优先队列中进行排序
//			pq.offer(new int[]{key ,value});
//		});
//		int[] ans = new int[k];
//		for (int i = 0; i < k; ++i) {	// 获取前k个高频元素
//			ans[i] = pq.poll()[0];
//		}
//		return ans;
//    }

	// 小顶堆优先队列
	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int num : nums) {	// 使用哈希表对数组元素个数进行统计
			hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
			return o1[1] - o2[1];
		}));
		hashMap.forEach((key, value) -> {	// 将哈希表元素保存到优先队列中进行排序
			pq.offer(new int[]{key ,value});
			if (pq.size() > k) 	// 维护队列中只排序k个元组
				pq.poll();
		});
		int[] ans = new int[k];
		for (int i = k-1; i >= 0; -- i) {	// 获取前k个高频元素
			ans[i] = pq.poll()[0];
		}
		return ans;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}