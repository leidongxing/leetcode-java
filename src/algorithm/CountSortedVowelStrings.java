package algorithm;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/1/7
 * 统计字典序元音字符串的数目
 */
public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        //"a","e","i","o","u"
        if (n == 1) {
            return 5;
        }
        // n=1 5
        // n=2 1*5 + 1*4 +1*3 +1*2 +1*1
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        int result = 0;
        for (int count : dp) {
            result += count;
        }
        return result;
    }
}
