package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2020/12/6
 * 杨辉三角
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            list.add(1);
            for (int j = 2; j <= i - 1; j++) {
                list.add(result.get(i - 2).get(j - 2) + result.get(i - 2).get(j - 1));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(10));
    }
}
