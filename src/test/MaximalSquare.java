package test;

/**
 * @author LeiDongxing
 * created on 2021/2/26
 * 最大正方形
 * 把遍历到的点看作是正方形的右下角  看与它左边/上边/左上是否能练成一个更大的正方形
 */
public class MaximalSquare {
    //dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
    //找到最长的边就能找到最大的正方形面积
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxSide = 0;
        //dp[i][j]表示以(i,j)为右虾饺 只包含1的正方形的边长的最大值
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        })); //4

        System.out.println(new MaximalSquare().maximalSquare(new char[][]{
                {'0', '1'},
                {'1', '0'}
        })); //1

        System.out.println(new MaximalSquare().maximalSquare(new char[][]{
                {'0'}
        })); //1
    }
}
