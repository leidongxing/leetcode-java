package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/1/23
 * 连通网络的操作次数
 */
public class NumberOfOperationsToMakeNetworkConnected {
    List<Integer>[] edges;
    boolean[] used;

    public int makeConnected1(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] conn : connections) {
            edges[conn[0]].add(conn[1]);
            edges[conn[1]].add(conn[0]);
        }

        used = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                dfs(i);
                result++;
            }
        }
        return result - 1;
    }

    private void dfs(int u) {
        used[u] = true;
        for (int v : edges[u]) {
            if (!used[v]) {
                dfs(v);
            }
        }
    }


    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] conn : connections) {
            uf.unite(conn[0], conn[1]);
        }
        //返回连通分量个数-1
        return uf.allCount - 1;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] size;
        private final int n;

        private int allCount;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            this.n = n;
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            this.allCount = n;
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public void unite(int x, int y) {
            if (connected(x, y)) {
                return;
            }
            if (size[x] < size[y]) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            parent[y] = x;
            size[x] += size[y];
            allCount--;
        }

        public boolean connected(int x, int y) {
            x = find(x);
            y = find(y);
            return x == y;
        }
    }
}
