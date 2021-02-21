package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/2/21
 * 和为K的子数组
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int result = 0, pre = 0;
        /**
         * 前缀和 map
         */
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                result += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return result;
    }

    /**
     * 暴力法
     */
    public int subarraySum1(int[] nums, int k) {
        int result = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        System.out.println(s.subarraySum(new int[]{1, 1, 1}, 2));
    }
}
