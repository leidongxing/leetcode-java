package test;

public class ReshapetheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) {
            return nums;
        } else {
            int[][] result = new int[r][c];
            int m = 0, n = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[0].length; j++) {
                    if (n >= c) {
                        m++;
                        n = 0;
                    }
                    result[m][n] = nums[i][j];
                    n++;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ReshapetheMatrix rm = new ReshapetheMatrix();
        rm.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
    }
}
