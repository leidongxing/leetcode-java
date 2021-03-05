package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/3/4
 * 俄罗斯套娃信封问题
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 1) {
            return envelopes.length;
        }
        //宽度递增  长度递减
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int result = 1;
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            //从前面开始地推
            for (int j = i - 1; j >= 0; j--) {
                //前面的比它小0000000
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > result) {
                        result = dp[i];
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes rd = new RussianDollEnvelopes();
        System.out.println(rd.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}, {3, 5}})); //3
        System.out.println(rd.maxEnvelopes(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}, {1, 1}})); //4
    }


}


