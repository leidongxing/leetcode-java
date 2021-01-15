package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/1/15
 * 移除最多的同行或同列石头
 */
public class MostStonesRemovedWithSameRowOrColumn {

    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (int[] stone : stones) {
            /**
             * 0 <= xi, yi <= 104
             */
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }


    private static class UnionFind {
        private final Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                //并查集中新加入一个节点  节点的父亲节点是它自己
                parent.put(x, x);
                //连通分量总数+1
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            //两个连通分量合并
            parent.put(rootX, rootY);
            //连通分量总数-1
            count--;
        }
    }
}
