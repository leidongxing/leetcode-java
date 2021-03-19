package test;

/**
 * @author LeiDongxing
 * created on 2021/3/19
 * 解码方法
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.startsWith("0")) {
            return 0;
        }


        int n = s.length();
        //dp[i][j] 从i到j的解码方法总数
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                //如果前一位不是1或者2,显然无法解码
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }
                //如果前一位是1或者2 是开头的只能拼成1个
                dp[i] = i == 1 ? 1 : dp[i - 2];
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                //开头的只能拼成上一个+1
                dp[i] = i == 1 ? dp[i - 1] + 1 : dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings("12"));//2
        System.out.println(d.numDecodings("226"));//3
        System.out.println(d.numDecodings("0"));//0
        System.out.println(d.numDecodings("06"));//0
    }
}
