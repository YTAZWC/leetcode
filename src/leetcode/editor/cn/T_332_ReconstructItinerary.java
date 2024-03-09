package leetcode.editor.cn;


import java.util.*;

/**
 * 332.重新安排行程
 * @author 花木凋零成兰
 * @date 2024-03-09 11:37:57
 */
public class T_332_ReconstructItinerary {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_332_ReconstructItinerary().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	LinkedList<String> ans = new LinkedList<>();
	Map<String, Map<String, Integer>> reflects = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
		// 建立机票之间起点到多个终点的映射
		for (List<String> ticket : tickets) {
			Map<String, Integer> reflect;	// 终点Map
			if (reflects.containsKey(ticket.get(0))) {
				reflect = reflects.get(ticket.get(0));	// 获取已存在的起点-终点映射
				reflect.put(ticket.get(1), reflect.getOrDefault(ticket.get(1), 0) + 1);
			} else {
				reflect = new TreeMap<>();	// 升序Map
				reflect.put(ticket.get(1), 1);	// 保存对应的终点及数目
			}
			reflects.put(ticket.get(0), reflect);	// 更新 起点-终点的映射
		}
		ans.add("JFK");	// 添加行程起点
		backtracking(tickets.size());
		return ans;
    }
	private boolean backtracking(int ticketNumber) {
		if (ans.size() == ticketNumber + 1)
			return true;	// 找到符合题意的行程
		String from = ans.getLast();
		if (reflects.containsKey(from)) {
			for (Map.Entry<String, Integer> ticket : reflects.get(from).entrySet()) {
				int count = ticket.getValue();	// 获取该起点对应的终点的数目
				if (count > 0) {	// 说明存在机票
					ans.add(ticket.getKey());	// 将对应终点添加到行程
					ticket.setValue(count-1);	// 修改机票数目
					if (backtracking(ticketNumber))
						return true;	// 找到符合题意的行程后 返回
					ans.removeLast();	// 回溯
					ticket.setValue(count);
				}
			}
		}
		return false;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}