package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LeiDongxing
 * created on 2021/8/1
 * 矩阵中战斗力最弱的K行
 */
public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        //军人数 行号
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return -Integer.compare(o1[0], o2[0]);
                } else {
                    return -Integer.compare(o1[1], o2[1]);
                }
            }
        });

        for (int i = 0; i < mat.length; i++) {
            int[] current = new int[]{0, i};
            for (int j = 0; j < mat[i].length; j++) {
                current[0] += mat[i][j];
            }
            queue.offer(current);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        int i = k - 1;
        while (!queue.isEmpty()) {
            result[i] = queue.poll()[1];
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        TheKWeakestRowsInAMatrix t = new TheKWeakestRowsInAMatrix();
        System.out.println(Arrays.toString(t.kWeakestRows(new int[][]{{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}}
                , 3)));
        System.out.println(Arrays.toString(t.kWeakestRows(new int[][]{{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}}, 2)));
    }
}
