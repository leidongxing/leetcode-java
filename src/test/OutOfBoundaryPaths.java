package test;

/**
 * @author LeiDongxing
 * created on 2021/8/15
 * 出界的路径数
 */
public class OutOfBoundaryPaths {
    int MOD = (int) 1e9 + 7;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    /**
     * @param m*n的网格
     * @param maxMove  最大移动次数
     * @param startRow startColumn 球起始坐标
     * @return 移出边界的路径数量
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] cache = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(cache, m, n, startRow, startColumn, maxMove);
    }

    private int dfs(int[][][] cache, int m, int n, int x, int y, int k) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (cache[x][y][k] != -1) {
            return cache[x][y][k];
        }
        int result = 0;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            result += dfs(cache, m, n, nx, ny, k - 1);
            result %= MOD;
        }
        cache[x][y][k] = result;
        return result;
    }
}
