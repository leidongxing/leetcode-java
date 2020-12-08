package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2020/12/8
 * 将数组拆分成斐波那契序列
 */
public class SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < S.length(); i++) {
            String s1 = S.substring(0, i);
            if (s1.charAt(0) == '0' && s1.length() > 1) {
                return list;
            }
            long f1 = Long.parseLong(S.substring(0, i));
            if (f1 > Integer.MAX_VALUE) {
                break;
            }
            list.add((int) f1);
            for (int j = 1; i + j < S.length(); j++) {
                String s2 = S.substring(i, i + j);
                if (s2.charAt(0) == '0' && s2.length() > 1) {
                    continue;
                }
                long f2 = Long.parseLong(s2);
                if (f2 > Integer.MAX_VALUE) {
                    break;
                }
                list.add((int) f2);
                if (backTrack(S, i + j, list)) {
                    return list;
                }
                list.remove(list.size() - 1);
            }
            list.remove(list.size() - 1);
        }
        return list;
    }

    private boolean backTrack(String S, int startIndex, List<Integer> list) {
        int f1 = list.get(list.size() - 2);
        int f2 = list.get(list.size() - 1);
        for (int i = 1; i <= S.length() - startIndex; i++) {
            String fs = S.substring(startIndex, startIndex + i);
            if (fs.charAt(0) == '0' && fs.length() > 1) {
                return false;
            }
            long f = Long.parseLong(fs);
            if (f > Integer.MAX_VALUE) {
                break;
            }
            if (f1 + f2 == f) {
                list.add((int) f);
                if (startIndex + i == S.length()) {
                    return true;
                } else {
                    if (backTrack(S, startIndex + i, list)) {
                        return true;
                    }
                }
                list.remove(list.size() - 1);
            } else if (f1 + f2 < f) {
                return false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SplitArrayIntoFibonacciSequence s = new SplitArrayIntoFibonacciSequence();
//        System.out.println(s.splitIntoFibonacci("123456579"));//[123,456,579]
//        System.out.println(s.splitIntoFibonacci("11235813"));//[1,1,2,3,5,8,13]
//        System.out.println(s.splitIntoFibonacci("112358130"));//[]
//        System.out.println(s.splitIntoFibonacci("1101111"));//[11, 0, 11, 11]
//        System.out.println(s.splitIntoFibonacci("0123"));//[]
//        System.out.println(s.splitIntoFibonacci("1011"));//[1,0,1,1]
//        System.out.println(s.splitIntoFibonacci("0000"));//[0, 0, 0, 0]
        System.out.println(s.splitIntoFibonacci("214748364721474836422147483641"));
    }
}
