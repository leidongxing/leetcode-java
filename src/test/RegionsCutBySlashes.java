package test;

/**
 * @author LeiDongxing
 * created on 2021/1/13
 * 由斜杠划分区域
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 */
public class RegionsCutBySlashes {
    //将小方块按照双线划分顺时针分为0,1,2,3 共4个区域
    // 1 2
    // 4 3
    // 当‘/’时，小方块的 0,3 区域连接， 1,2区域连接
    //当‘\\’时 ，小方块的 0,1区域连接，2,3区域连接
    //当‘ ’时，小方块4个区域连接
    public int regionsBySlashes(String[] grid) {
        int length = grid.length;
        // 总共有 4n * n 个 小区域块
        UnionFind uf = new UnionFind(4 * length * length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int start = 4 * (i * length + j);
                switch (grid[i].charAt(j)) {
                    case ' ':
                        uf.merge(start, start + 1);
                        uf.merge(start + 2, start + 3);
                        uf.merge(start, start + 2);
                        break;
                    case '/':
                        uf.merge(start, start + 3);
                        uf.merge(start + 1, start + 2);
                        break;
                    case '\\':
                        uf.merge(start, start + 1);
                        uf.merge(start + 2, start + 3);
                        break;
                }
                if (i > 0) {
                    uf.merge(start, start - 4 * length + 2);
                }
                if (j > 0) {
                    uf.merge(start + 3, start - 3);
                }
            }
        }

        // 此时取出index = parent[index] 的节点即可 即算出有多少颗树就是有多少个区域
        int count = 0;
        for (int i = 0; i < uf.parent.length; i++) {
            if (i == uf.parent[i]){
                count++;
            }
        }
        return count;
    }


    private class UnionFind {
        int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int find(int index) {
            while (index != parent[index]) {
                index = parent[index];
            }
            return index;
        }

        public void merge(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            parent[pRoot] = qRoot;
        }
    }
}
