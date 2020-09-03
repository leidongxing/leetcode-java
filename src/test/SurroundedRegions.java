package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * create on 2020/8/11 22:52
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    draw(board, i, j);
                }
            }
        }
        System.out.println(Arrays.deepToString(board));
    }

    private void draw(char[][] board, int m, int n) {
        board[m][n] = 'X';
        if (m == 0 || n == 0 || m == board.length - 1 || n == board[0].length - 1) {
            return;
        }
        draw(board, m + 1, n);
        draw(board, m - 1, n);
        draw(board, m, n + 1);
        draw(board, m, n - 1);
    }


    public static void main(String[] args) {
        new SurroundedRegions().solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
        new SurroundedRegions().solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }
}
