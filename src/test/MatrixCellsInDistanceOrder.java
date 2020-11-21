package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author LeiDongxing
 * created on 2020/11/17
 * 距离顺序排列矩阵单元格
 */
public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(result, Comparator.comparingInt(a -> (Math.abs(a[0] - r0) + Math.abs(a[1] - c0))));
        return result;
    }

    int[] dr = {1, 1, -1, -1};
    int[] dc = {1, -1, -1, 1};

    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int max = Math.max(r0, R - r0 - 1) + Math.max(c0, C - c0 - 1);
        int[][] result = new int[R * C][];
        result[0] = new int[]{r0, c0};
        int index = 1;

        int row = r0, col = c0;
        for (int dist = 1; dist <= max; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
                    if (row >= 0 && row < R && col >= 0 && col < C) {
                        result[index] = new int[]{row, col};
                        index++;
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return result;
    }
}
