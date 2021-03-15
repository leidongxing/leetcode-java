package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/3/15
 * 螺旋矩阵
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        int dir = 1;
        int row = 0;
        int col = 0;

        while (top <= bottom && left <= right) {
            result.add(matrix[row][col]);
            switch (dir) {
                case 1: {
                    if (col == right) {
                        top++;
                        dir = 2;
                        row++;
                        continue;
                    }
                    col++;
                    break;
                }
                case 2: {
                    if (row == bottom) {
                        right--;
                        dir = 3;
                        col--;
                        continue;
                    }
                    row++;
                    break;
                }
                case 3: {
                    if (col == left) {
                        bottom--;
                        dir = 4;
                        row--;
                        continue;
                    }
                    col--;
                    break;
                }
                case 4: {
                    if (row == top) {
                        left++;
                        dir = 1;
                        col++;
                        continue;
                    }
                    row--;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        System.out.println(s.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));//[1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(s.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));//[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
