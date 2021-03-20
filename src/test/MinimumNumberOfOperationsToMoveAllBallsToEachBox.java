package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/3/20
 * 移动所有球到每个盒子所需的最小操作数
 */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        //第i个盒子最小操作数
        int[] dp = new int[boxes.length()];

        //右边移动操作数
        int right = 0;
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) - '0' == 1) {
                dp[0] += i;
                right++;
            }
        }

        int left = 0;
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i - 1) - '0' == 1) {
                left++;
                right--;
            }
            dp[i] = dp[i - 1] - right + left;
        }

        return dp;
    }


    public int[] minOperations1(String boxes) {
        int[] result = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            for (int j = 0; j < boxes.length(); j++) {
                result[i] += (boxes.charAt(j) - '0') * Math.abs(i - j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMoveAllBallsToEachBox m = new MinimumNumberOfOperationsToMoveAllBallsToEachBox();
        System.out.println(Arrays.toString(m.minOperations("110"))); //[1,1,3]
        System.out.println(Arrays.toString(m.minOperations("001011")));//[11, 8, 5, 4, 3, 4]
    }
}
