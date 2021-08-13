package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/2/15
 * 格雷编码
 */
public class GrayCode {
    /**
     * 位运算解法
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(head + result.get(j));
            }
            head <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode g = new GrayCode();
        System.out.println(g.grayCode(0));// 0
        System.out.println(g.grayCode(1));// 0 1 3 2
        System.out.println(g.grayCode(2));// 0 1 3 2
    }
}
