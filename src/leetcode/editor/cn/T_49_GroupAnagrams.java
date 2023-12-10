package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49.字母异位词分组
 * @author 花木凋零成兰
 * @date 2023-12-10 17:15:42
 */
public class T_49_GroupAnagrams {
	 public static void main(String[] args) {
	     //测试代码
	     Solution solution = new T_49_GroupAnagrams().new Solution();
	 
	 }
	 
// 力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//		// 哈希表 统计字母异位词 出现的 字符串
//		HashMap<String, List<String>> hashString = new HashMap<>();
//        for (String str : strs) {	// 遍历数组strs
//            char[] charArray = str.toCharArray();	// 将字符串转化为字符数组
//            Arrays.sort(charArray);		// 对字符数组进行排序
//            String string = Arrays.toString(charArray);	// 将排序好的字符数组转化为字符串
//            List<String> stringList;	// 保存 相互为字母异位词的 字符串
//            if (hashString.containsKey(string)) {	// 若哈希表中已存在该种字母异位词
//                stringList = hashString.get(string);	// 则将保存列表返回
//            } else {
//                stringList = new ArrayList<>();		// 否则创建新列表
//            }
//            stringList.add(str);	// 将该字符串保存到对应的 字母异位词列表中
//            hashString.put(string, stringList); // 并保存到哈希表
//        }
//		return new ArrayList<>(hashString.values());	// 将哈希表中的结果返回
//    }

	public List<List<String>> groupAnagrams(String[] strs) {
		// 哈希表 统计字母异位词 出现的 字符串
		HashMap<String, List<String>> hashString = new HashMap<>();
		for (String str : strs) {	// 遍历数组strs
			// 获取字符统计结果字符串
			String recordsByString = getRecordsByString(str);
			List<String> strsList = hashString.getOrDefault(recordsByString, new ArrayList<>());
			strsList.add(str);	// 将其添加到哈希表的值中
			hashString.put(recordsByString, strsList);
		}
		return new ArrayList<>(hashString.values());	// 将哈希表中的结果返回
	}
	// 对字符串出现的字符及数量进行统计
	// 将统计的字符 及其数目 拼接成字符串返回
	public String getRecordsByString(String str) {
		int[] records = new int[26];
		int len = str.length();
		for (int i = 0; i < len; ++i) {
			records[ str.charAt(i) - 'a' ] ++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; ++i) {
			if (records[i] != 0) {
				sb.append(i+'a');
				sb.append(records[i]);
			}
		}
		return sb.toString();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}