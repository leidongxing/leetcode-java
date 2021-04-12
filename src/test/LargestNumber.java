package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LeiDongxing
 * created on 2021/4/12
 * 最大数
 */
public class LargestNumber {
    /**
     * 最大数
     */
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new LargestNumberComparator());
        if ("0".equals(str[0])) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * 自定义排序器
     */
    private static class LargestNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String A = a + b;
            String B = b + a;
            return -A.compareTo(B);
        }
    }

    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        System.out.println(ln.largestNumber(new int[]{10, 2}));//210
        System.out.println(ln.largestNumber(new int[]{3, 30, 34, 5, 9}));//9534330
        System.out.println(ln.largestNumber(new int[]{1}));
        System.out.println(ln.largestNumber(new int[]{10}));
        System.out.println(ln.largestNumber(new int[]{10, 2, 9, 39, 17}));
    }
}
