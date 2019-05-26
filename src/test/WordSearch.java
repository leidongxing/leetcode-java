package test;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] charWord = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == charWord[0]) {
                    int k = charWord.length - 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}
