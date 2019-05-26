package test;

import java.util.ArrayList;
import java.util.List;

public class PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (S == null || S.equals("")) {
            return result;
        }
        char[] schar = S.toCharArray();
        int nums = 1;
        int start = 0;
        char current = schar[0];
        for (int i = 1; i < schar.length; i++) {
            if (schar[i] != current) {
                if (nums >= 3) {
                    List<Integer> al = new ArrayList<Integer>();
                    al.add(start);
                    al.add(i - 1);
                    result.add(al);
                }
                nums = 1;
                current = schar[i];
                start = i;
            } else {
                nums++;
            }
        }
        if (nums >= 3) {
            List<Integer> al = new ArrayList<Integer>();
            al.add(start);
            al.add(schar.length - 1);
            result.add(al);
        }

        return result;
    }
}
