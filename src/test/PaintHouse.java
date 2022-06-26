package test;

/**
 * @author LeiDongxing
 * created on 2021/5/4
 * 粉刷房子
 */
public class PaintHouse {

    /**
     * @param houses houses[i] 第i个房子的颜色，0表示这个房子还没有被涂色
     * @param cost   cost[i][j]：是将第i个房子涂成颜色j+1的花费
     * @param m      m个房子排成一排
     * @param n      需要涂上n种颜色
     * @param target 每个房子都被涂色后恰好组成target个街区
     * @return 房子涂色方案的最小总花费 没有可用的涂色方案返回-1
     */
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int infty = Integer.MAX_VALUE / 2;
        //dp[i][j][k] 涂完前i个房子 目前有j个街区 第i个房子颜色为k的最小cost方案
        int[][][] dp = new int[m + 1][target + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    dp[i][j][k] = infty;
                }
            }
        }
        if (houses[0] > 0) {
            dp[0][1][houses[0]] = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                dp[0][1][i] = cost[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= target; j++) {
                if (houses[i] > 0) {
                    int temp = houses[i];
                    for (int k = 1; k <= n; k++) {
                        // 分成第i个房子和第i-1的房子
                        // 如果两个房子颜色相同，那么街区数就相同
                        // 如果两个房子颜色不同，那么第i个房子就独自成一个街区
                        if (temp == k) {
                            dp[i][j][temp] = Math.min(dp[i][j][temp], dp[i - 1][j][k]);
                        } else {
                            dp[i][j][temp] = Math.min(dp[i][j][temp], dp[i - 1][j - 1][k]);
                        }
                    }
                } else {
                    for (int k = 1; k <= n; k++) {
                        for (int s = 1; s <= n; s++) {
                            if (k == s) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][s] + cost[i][k - 1]);
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][s] + cost[i][k - 1]);
                            }
                        }
                    }
                }
            }
        }
        int result = infty;
        for (int i = 1; i <= n; i++) {
            result = Math.min(result, dp[m - 1][target][i]);
        }
        return result == infty ? -1 : result;
    }

    /**
     * @param costs n*3的矩阵  costs[0][0]costs[0][1]costs[0][2]第0号房子粉刷成红色、蓝色、绿色的成本
     * @return 粉刷完所有房子最少的花费成本
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        int a = costs[0][0];
        int b = costs[0][1];
        int c = costs[0][2];
        for (int i = 1; i < n; i++) {
            int d = Math.min(b, c) + costs[i][0];
            int e = Math.min(a, c) + costs[i][1];
            int f = Math.min(a, b) + costs[i][2];
            a = d;
            b = e;
            c = f;
        }
        return Math.min(Math.min(a, b), c);
    }


    public static void main(String[] args) {
        PaintHouse p = new PaintHouse();
        System.out.println(p.minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));//9
        System.out.println(p.minCost(new int[]{0, 2, 1, 2, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3));//11
        System.out.println(p.minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}}, 5, 2, 5));//5
        System.out.println(p.minCost(new int[]{3, 1, 2, 3}, new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 4, 3, 3));//-1

        System.out.println(p.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));//2 + 5 + 3 = 10
        System.out.println(p.minCost(new int[][]{{7, 6, 2}})); //2
    }
}
