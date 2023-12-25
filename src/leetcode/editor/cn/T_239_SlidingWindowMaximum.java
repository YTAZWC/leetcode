package leetcode.editor.cn;


import java.util.*;

/**
 * 239.滑动窗口最大值
 * @author 花木凋零成兰
 * @date 2023-12-25 15:13:20
 */
public class T_239_SlidingWindowMaximum {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_239_SlidingWindowMaximum().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//		int n = nums.length;	// 数组nums长度
//		// 创建 优先队列 并设置堆中元素比较方式
//		PriorityQueue<int[]> pq = new PriorityQueue<>(
//				(o1, o2) -> o1[0] != o2[0]? o2[0]-o1[0] : o2[1] - o1[1]
//		);
//		// 先将第一组滑动窗口 添加到优先队列中
//		for (int i = 0; i < k; ++ i) {
//			pq.offer(new int[]{nums[i], i});
//		}
//		int[] ans = new int[n-k+1];		// 返回最大值结果数组 且一共有n-k+1个窗口
//        ans[0] = pq.peek()[0];
//		// 移动滑动窗口 进行遍历
//		for (int i = k; i < n; ++ i) {
//			pq.offer(new int[]{nums[i], i});	// 将右窗口元素加入到优先队列中
//			while (pq.peek()[1] <= i-k) {	// 将不在窗口内的最大值移除
//				pq.poll();
//			}
//			ans[i-k+1] = pq.peek()[0];	// 记录窗口内的最大值
//		}
//		return ans;
//    }

//	public int[] maxSlidingWindow(int[] nums, int k) {
//		int n = nums.length;	// 数组nums长度
//		Deque<Integer> deque = new ArrayDeque<>();	// 双端队列 用作维护单调队列
//		int[] ans = new int[n-k+1];		// 返回结果数组 且计算得滑动窗口数量为n-k+1
//		for (int i = 0; i < k; ++i) {	// 将第一组滑动窗口元素加入队列中
//			// 将小于新元素的队尾元素 移除队列
//			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
//				deque.pollLast();
//			}
//			deque.offerLast(i);	// 将新元素添加到队尾
//		}
//		ans[0] = nums[deque.peekFirst()];
//		for (int i = k; i < n; ++i) {
//			// 将队尾小于新元素的数组元素 移除
//			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
//				deque.pollLast();
//			deque.offerLast(i);		// 将新元素添加到队尾
//			// 将队首 不在滑动窗口内的最大值移除
//			while (!deque.isEmpty() && deque.peekFirst() <= i-k)
//				deque.pollFirst();
//			ans[i-k+1] = nums[deque.peekFirst()];
//		}
//		return ans;
//	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] ans = new int[n-k+1];
		int index = 0;
		MyQueue myQueue = new MyQueue();	// 自定义单调队列
		for (int i = 0; i < k; ++ i) {	// 将第一组滑动窗口添加到单调队列中
			myQueue.push(nums[i]);
		}
		ans[index++] = myQueue.peek();
		for (int i = k; i < n; ++ i) {
			// 移动滑动窗口 此时移除左窗口旧元素
			myQueue.pop(nums[i-k]);
			// 将右窗口新元素 添加到队列中
			myQueue.push(nums[i]);
			// 记录新窗口内的最大值
			ans[index++] = myQueue.peek();
		}
		return ans;
	}

// 自定义单调队列
class MyQueue {
	Deque<Integer> deque = new LinkedList<>();

	// 弹出元素时 比较当前队首元素是否等于队列出口的数值 相等则弹出
	void pop(int val) {
		if (!deque.isEmpty() && deque.peekFirst() == val)
			deque.pollFirst();
	}
	// 判断新元素 与 队尾元素
	// 如果队尾元素 小于 新元素 则弹出
	void push(int val) {
		while (!deque.isEmpty() && deque.peekLast() < val)
			deque.pollLast();
		deque.offerLast(val);
	}
	// 获取队列队首元素 即窗口内的最大值
	int peek() {
		return deque.peekFirst();
	}
}
}
//leetcode submit region end(Prohibit modification and deletion)

}