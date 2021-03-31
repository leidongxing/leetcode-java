package test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LeiDongxing
 * created on 2021/3/31
 * 找到小镇的法官
 */
public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            outDegree[trust[i][0]]++;
            inDegree[trust[i][1]]++;
        }
        for (int j = 1; j <= N; j++) {
            //入读为N  出度0
            if (inDegree[j] == N - 1 && outDegree[j] == 0) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheTownJudge f = new FindTheTownJudge();
        System.out.println(f.findJudge(2, new int[][]{{1, 2}, {2, 1}}));
    }
}
