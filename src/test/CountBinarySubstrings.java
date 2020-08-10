package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * create on 2020/8/10 22:18
 * 计数二进制子串
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int start = 0, end = s.length();
        while (start < end) {
            char c = s.charAt(start);
            int count = 0;
            while (start < end && s.charAt(start) == c) {
                start++;
                count++;
            }
            counts.add(count);
        }
        int result = 0;
        //相邻的最小值
        for (int i = 1; i < counts.size(); i++) {
            result += Math.min(counts.get(i), counts.get(i - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("00110011"));
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("10101"));
    }
}
