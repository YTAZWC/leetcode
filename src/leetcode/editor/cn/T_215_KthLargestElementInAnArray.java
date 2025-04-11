package leetcode.editor.cn;

/**
 * 215.数组中的第K个最大元素
 * @author 花木凋零成兰
 * @date 2025-04-11 10:09:36
 */
public class T_215_KthLargestElementInAnArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new T_215_KthLargestElementInAnArray().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        PriorityQueue<Integer> deque = new PriorityQueue<>((o1, o2) -> o1 - o2);
//        for (int i = 0; i < nums.length; ++ i) {
//            deque.add(nums[i]);
//            if (deque.size() > k) {
//                deque.poll();
//            }
//        }
//        return deque.poll();
//    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickStart(nums, 0, n-1, n-k);
    }

    private int quickStart(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }
        int partition = nums[l];
        int i = l-1;
        int j = r+1;
        while (i < j) {
            do ++ i; while (nums[i] < partition);
            do -- j; while (nums[j] > partition);
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        if (k <= j) {
            return quickStart(nums, l, j, k);
        } else {
            return quickStart(nums, j+1, r, k);
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
