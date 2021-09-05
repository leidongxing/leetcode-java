package test;

/**
 * @author LeiDongxing
 * created on 2021/8/14
 * 统计不开心的朋友
 */
public class CountUnhappyFriends {
    /**
     * @param n           位朋友的亲切程度列表 n为偶数
     * @param preferences preferences[i] 按亲近程度从高到低排列的朋友列表
     * @param pairs       配对情况
     * @return 配对中不开心的朋友
     */
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] order = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                order[i][preferences[i][j]] = j;
            }
        }

        int[] match = new int[n];
        for (int[] pair : pairs) {
            int person0 = pair[0];
            int person1 = pair[1];
            match[person0] = person1;
            match[person1] = person0;
        }

        int result = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = order[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
