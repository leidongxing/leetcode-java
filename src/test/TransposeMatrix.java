package test;

public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TransposeMatrix t = new TransposeMatrix();
        t.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
