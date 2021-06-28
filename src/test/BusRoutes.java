package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/6/28
 */
public class BusRoutes {

    /**
     * 公交路线
     *
     * @param routes 公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶
     * @param source 车站出发（初始时不在公交车上）
     * @param target target 车站
     * @return 最少乘坐的公交车数量 不可能到达终点车站，返回 -1
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        return bfs(routes, source, target);
    }

    private int bfs(int[][] routes, int source, int target) {
        //车站可以进入的路线
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //经过的路线
        Deque<Integer> deque = new ArrayDeque<>();
        //进入该路线的距离
        Map<Integer, Integer> m = new HashMap<>();
        int n = routes.length;
        for (int i = 0; i < n; i++) {
            for (int station : routes[i]) {
                //从起点可以进入的路线 加入队列
                if (station == source) {
                    deque.addLast(i);
                    m.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            int step = m.get(poll);
            for (int station : routes[poll]) {
                if (station == target) {
                    return step;
                }
                Set<Integer> lines = map.get(station);
                if (lines == null) {
                    continue;
                }
                for (int nr : lines) {
                    //已经入队 不能再次入队
                    if (!m.containsKey(nr)) {
                        m.put(nr, step + 1);
                        deque.add(nr);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BusRoutes().numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));//2
        System.out.println(new BusRoutes().numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12));//-1
    }
}
