package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/7/7
 * 大餐计数
 */
public class CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        int MOD = 1000000007;
        int maxVal = 0;
        for (int i : deliciousness) {
            maxVal = Math.max(maxVal, i);
        }
        //能达到的最大sum
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
}
