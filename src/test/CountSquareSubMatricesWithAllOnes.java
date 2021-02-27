package test;

/**
 * @author LeiDongxing
 * created on 2021/2/27
 * 统计全为1的正方形子矩阵
 * 把遍历到的点看作是正方形的右下角  看与它左边/上边/左上是否能练成一个更大的正方形
 */
public class CountSquareSubMatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    result += dp[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountSquareSubMatricesWithAllOnes().countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        })); //15  10+4+1

        System.out.println(new CountSquareSubMatricesWithAllOnes().countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        })); //7   6+1
    }
}
