package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2020/12/26
 * 最大矩形
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //每个元素 左边连续1的数量
        //left[i][j] 为矩阵第i行第j列元素的左边连续1的数量。
        int[][] left = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                //如果出现1 宽度最大就为left[i][j]
                int width = left[i][j];
                int area = width;

                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    //高度=i-k+1
                    area = Math.max(area, (i - k + 1) * width);
                }
                result = Math.max(result, area);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        //[[1, 0, 1, 0, 0],
        // [1, 0, 1, 2, 3],
        // [1, 2, 3, 4, 5],
        // [1, 0, 0, 1, 0]]
        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}}));

        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{{}}));
        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{{'0'}}));
        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{{'1'}}));
        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{{'0', '0'}}));

    }
}
