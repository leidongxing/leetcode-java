package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2020/11/11
 * 自由之路
 */
public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < ring.length(); ++i) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[key.length()][ring.length()];
        for (int i = 0; i < key.length(); ++i) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, ring.length() - i) + 1;
        }
        for (int i = 1; i < key.length(); ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), ring.length() - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[key.length() - 1]).min().getAsInt();
    }
    public static void main(String[] args){
        System.out.println(0x3f3f3f3f);
    }
}
