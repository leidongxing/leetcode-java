package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2022/7/9
 * 最长的斐波那契子序列的长度
 */
public class LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            //从后到前 递增序列 不小于arr[i]
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    //斐波那契子序列的长度至少为3
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                result = Math.max(result, dp[j][i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsequence l = new LengthOfLongestFibonacciSubsequence();
        System.out.println(l.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8})); //[1,2,3,5,8]   5
        System.out.println(l.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18})); //[1,11,12]、[3,11,14]以及[7,11,18] 3
    }
}
