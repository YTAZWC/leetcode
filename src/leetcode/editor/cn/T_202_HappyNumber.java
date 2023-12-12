package leetcode.editor.cn;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 202.快乐数
 * @author 花木凋零成兰
 * @date 2023-12-12 11:43:05
 */
public class T_202_HappyNumber {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_202_HappyNumber().new Solution();
		 boolean happy = solution.isHappy(15);
		 System.out.println(happy);
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public boolean isHappy(int n) {
//		if (n == 1) {
//			return true;
//		}
//		HashMap<Integer, Integer> hashMap = new HashMap<>();
//		int num = n;
//		while(num != 1) {
//			// 首先判断哈希表中有无该数的各个位数的平方和
//			if (hashMap.containsKey(num)) {
//				num = hashMap.get(num);
//			} else {
//				// 计算各个位 数的平方和
//				int sum = 0;
//				int t = num;
//				while (num != 0) {
//					int x = num%10;
//					sum += x*x;
//					num /= 10;
//				}
//				num = sum;
//				hashMap.put(t, sum);
//			}
//			if (num == 4) {
//				return false;
//			}
//		}
//		return true;
//    }

//	public boolean isHappy(int n) {
//		if (n == 1) {
//			return true;
//		}
//		int num = n;
//		while(num != 1) {
//			// 计算各个位 数的平方和
//			int sum = 0;
//			while (num != 0) {
//				int x = num % 10;
//				sum += x * x;
//				num /= 10;
//			}
//			num = sum;
//			if (num == 4) {
//				return false;
//			}
//		}
//		return true;
//	}

//	public boolean isHappy(int n) {
//		HashSet<Integer> hashSet = new HashSet<>();		// 哈希集合 记录计算得到的数字判断是否进入循环
//		int x = n;
//		while (x != 1) {
//			if (hashSet.contains(x)) {	// 如若集合中存在该数 则进入循环 返回false
//				return false;
//			} else {
//				hashSet.add(x);		// 集合中不含有该元素 则保存该元素到集合中
//				// 计算下一位
//				int t = 0;
//				while (x != 0) {
//					int y = x % 10;
//					t += y * y;
//					x /= 10;
//				}
//				x = t;	// 更新下一位判断的数值
//			}
//		}
//		return true;
//	}

	public boolean isHappy(int n) {
		int fast = n;	// 快指针
		int slow = n;	// 慢指针
		do {
			// 快指针移动
			fast = bitSquareSum(fast);
			fast = bitSquareSum(fast);
			// 慢指针移动
			slow = bitSquareSum(slow);
		} while(fast != slow);
		return slow == 1;	// 判断相遇时 是否为1
	}
	// 获取一个数的各个位上的 数的平方和
	public int bitSquareSum(int x) {
		int sum = 0;
		while (x != 0) {
			int t = x % 10;
			sum += t * t;
			x /= 10;
		}
		return sum;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}