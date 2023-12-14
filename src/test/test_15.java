package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class test_15 {


    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        a.add(-1);
        a.add(0);
        a.add(1);

        b.add(0);
        b.add(1);
        b.add(-1);

        c.add(-1);
        c.add(2);
        c.add(-1);
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        set.add(a);
        ans.add(a);
        if (set.add(b))
            ans.add(b);
        if (set.add(c))
            ans.add(c);

        System.out.println(ans.toString());
    }

}
