package test;

/**
 * 单词搜索
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        //标记是否已经被使用  初始化为false
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int start) {
        //不等于 直接返回false
        if (board[i][j] != s.charAt(start)) {
            return false;
        } else if (start == s.length() - 1) {
            //等于 且已经到最后 返回true
            return true;
        }
        visited[i][j] = true;
        //定义四个方向
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, start + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        //还原
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}
