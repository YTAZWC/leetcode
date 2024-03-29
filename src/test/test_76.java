package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test_76 {

    public static void main(String[] args) {
        HashMap<Character, Integer> a = new HashMap<>();
        HashMap<Character, Integer> b = new HashMap<>();
        a.put('a', 212121);
        b.put('a', 2121222);

        System.out.println(a.getOrDefault('a', 0) < b.get('a'));

        int[][] array = new int[][]{};

        System.out.println(Arrays.deepToString(array));
        System.out.println(array.length);

        String[] strs = {""};
        System.out.println(strs.length);

        System.out.println( 1 << 2 << 3);

        System.out.println(getBinaryByString("bd"));
        System.out.println(getBinaryByString("aacc"));

    }

    public static int getBinaryByString(String str) {
        char[] charArray = str.toCharArray();
        int binaryNumber = 0;
        for (char ch: charArray) {
            int index = ch - 'a';
            binaryNumber += (1 << index);
        }
        return binaryNumber;
    }

}

class ListNode {
    int val;    // 数据域 存储链表节点上的数据
    ListNode next;      // 指针域 指向该节点的下一个节点

    public ListNode(){  // 节点无参构造方法

    }

    public ListNode(int val) {  // 节点 有参(一个参数)构造方法
        this.val = val;
        next = null;
    }

    public ListNode(int val, ListNode next) {   // 节点 有参(两个参数)构造方法
        this.val = val;
        this.next = next;
    }
}
