package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2022/2/9
 * 差的绝对值为K的数对数目
 */
public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        int result = 0;
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            result += cnt.getOrDefault(nums[i] - k, 0) + cnt.getOrDefault(nums[i] + k, 0);
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        return result;
    }


    public int countKDifference1(int[] nums, int k) {
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    result++;
                }
            }
        }
        return result;
    }


}
