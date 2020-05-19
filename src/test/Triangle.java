package test;

import java.util.List;

/**
 * @author LeiDongxing
 * created on 2020/5/19
 * 120
 */
public class Triangle {
    private int min = Integer.MAX_VALUE;

    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.isEmpty() || triangle.get(0).isEmpty()) {
            return min;
        }
        dfs(triangle, 0, 0, 0);
        return min;
    }

    public int dfs(List<List<Integer>> triangle, int i, int j, int path) {
        if (i == triangle.size() - 1) {
            path += triangle.get(i).get(j);
            //dfs(triangle, 0, j + 1, path);
            if (path <= min) {
                min = path;
            }
            return min;
        }
        path += triangle.get(i).get(j);
        //去左边
        dfs(triangle, i + 1, j, path);
        //去右边
        dfs(triangle, i + 1, j + 1, path);
        return min;
    }

    /**
     * dp[i][j]表示到达第i层第j个位置的最小和
     *  dp[i][j]=min dp[i-1][j]  dp[i-1][j-1]  +triangle[i][j]
     * 从上往下思考
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] dp = new int[length + 1][length + 1];
        for (int i = length - 1; i >= 0; i--) {
            List<Integer> l = triangle.get(i);
            for (int j = 0; j < l.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + l.get(j);
            }
        }
        return dp[0][0];
    }
}
