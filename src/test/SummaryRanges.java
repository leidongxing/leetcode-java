package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/1/10
 * 汇总区间
 */
public class SummaryRanges {
    public List<String> summaryRanges1(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = end + 1;
            } else {
                if (end > start) {
                    result.add(start + "->" + end);
                } else {
                    result.add(String.valueOf(start));
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if (end > start) {
            result.add(start + "->" + end);
        } else {
            result.add(String.valueOf(start));
        }
        return result;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int i = 0;
        while (i < nums.length) {
            int start = i;
            i++;
            while (i < nums.length && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int end = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[start]));
            if (start < end) {
                temp.append("->");
                temp.append(nums[end]);
            }
            result.add(temp.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{}));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{-1}));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0}));
    }
}
