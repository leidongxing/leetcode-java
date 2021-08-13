package test;

/**
 * @author LeiDongxing
 * created on 2021/2/14
 * 情侣牵手
 * 将N对情侣看成图中的N个节点
 * 对于每对相邻的位置 i和j坐在一起 i与j之间有一条边
 * 连通分量即为需要交换的次数
 */
public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        Union union = new Union(row.length / 2);
        for (int i = 0; i < row.length; i += 2) {
            union.union(row[i] / 2, row[i + 1] / 2);
        }
        return union.getCount();
    }

    private static class Union {
        int count;
        int[] f;

        public Union(int n) {
            this.count = 0;
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        public int find(int x) {
            int fx = f[x];
            if (fx != f[fx]) {
                f[x] = find(fx);
            }
            return f[x];
        }

        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                f[fx] = fy;
                count++;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
