package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/7/19
 * 最高频元素的频数
 */
public class FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1;
        int n = nums.length;
        long total = 0;
        int l = 0;
        for (int r = 1; r < n; r++) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
