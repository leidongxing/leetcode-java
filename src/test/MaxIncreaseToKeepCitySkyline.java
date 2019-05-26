package test;

public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int sum = 0;
        int[][] wgrid = new int[grid.length][grid[0].length];
        int[][] hgrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int wMax = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (wMax < grid[i][j]) {
                    wMax = grid[i][j];
                }
            }
            for (int j = 0; j < wgrid[i].length; j++) {
                wgrid[i][j] = wMax;
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            int hMax = 0;
            for (int j = 0; j < grid.length; j++) {
                if (hMax < grid[j][i]) {
                    hMax = grid[j][i];
                }
            }
            for (int j = 0; j < hgrid[i].length; j++) {
                hgrid[j][i] = hMax;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += (Math.min(wgrid[i][j], hgrid[i][j]) - grid[i][j]);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        MaxIncreaseToKeepCitySkyline m = new MaxIncreaseToKeepCitySkyline();
        m.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}});
    }
}
