package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/5/8
 * 完成所有工作的最短时间
 */
public class FindMinimumTimeToFinishAllJobs {
    int[] jobs;
    int n, k;


    public int minimumTimeRequired(int[] _jobs, int _k) {
        int ans = Integer.MAX_VALUE;
        jobs = _jobs;
        n = jobs.length;
        k = _k;
        int[] sum = new int[k];
        dfs(0, 0, sum, 0, ans);
        return ans;
    }

    /**
     * 【补充说明】不理解可以看看下面的「我猜你问」的 Q5 哦 ~
     * <p>
     * u     : 当前处理到那个 job
     * used  : 当前分配给了多少个工人了
     * sum   : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
     * max   : 当前的「最大工作时间」
     */
    void dfs(int u, int used, int[] sum, int max, int ans) {
        if (max >= ans) {
            return;
        }
        if (u == n) {
            ans = max;
            return;
        }
        // 优先分配给「空闲工人」
        if (used < k) {
            sum[used] = jobs[u];
            dfs(u + 1, used + 1, sum, Math.max(sum[used], max), ans);
            sum[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            sum[i] += jobs[u];
            dfs(u + 1, used, sum, Math.max(sum[i], max), ans);
            sum[i] -= jobs[u];
        }
    }


    public static void main(String[] args) {
        FindMinimumTimeToFinishAllJobs f = new FindMinimumTimeToFinishAllJobs();
        System.out.println(f.minimumTimeRequired(new int[]{3, 2, 3}, 3));//3
        System.out.println(f.minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));//11
    }
}
