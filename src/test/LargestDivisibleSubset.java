package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/4/23
 * 最大整除子集
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //找出最大子集个数
        int maxSize = 1;
        //找出最大个数
        int maxVal = dp[0];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        List<Integer> result = new ArrayList<>();
        if (maxSize == 1) {
            result.add(nums[0]);
            return result;
        }
        for (int i = nums.length - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                result.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset l = new LargestDivisibleSubset();
        System.out.println(l.largestDivisibleSubset(new int[]{2, 3, 4, 9, 8}));
        System.out.println(l.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(l.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}
