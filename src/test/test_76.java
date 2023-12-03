package test;

import java.util.HashMap;

public class test_76 {



    public static void main(String[] args) {
        HashMap<Character, Integer> a = new HashMap<>();
        HashMap<Character, Integer> b = new HashMap<>();
        a.put('a', 212121);
        b.put('a', 2121222);

        System.out.println(a.getOrDefault('a', 0) < b.get('a'));

    }

}
