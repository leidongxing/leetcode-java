package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/3/7
 * 分割回文串
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return Collections.emptyList();
        }

        int n = s.length();
        //dp(i,j)表示子串i j是否为回文串
        boolean[][] dp = new boolean[n][n];
        //先全部填充成true
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }

        List<List<String>> result = new ArrayList<>();
        find(s, 0, dp, new ArrayList<>(), result);
        return result;
    }


    private void find(String s, int start, boolean[][] dp, List<String> current, List<List<String>> result) {
        if (start >= s.length()) {
            List<String> tmpList = new ArrayList<>(current);
            result.add(tmpList);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                current.add(s.substring(start, i + 1));
                find(s, i + 1, dp, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("abb"));
        System.out.println(new PalindromePartitioning().partition("acca"));
        System.out.println(new PalindromePartitioning().partition("c"));
        System.out.println(new PalindromePartitioning().partition("abc"));
    }
}
