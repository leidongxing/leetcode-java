package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LeiDongxing
 * created on 2021/8/5
 * 找到最终的安全状态
 */
public class FindEventualSafeStates {
    /**
     * 拓扑排序
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rg = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            rg.add(new ArrayList<>());
        }
        int[] inDeg = new int[n];
        for (int x = 0; x < n; ++x) {
            for (int y : graph[x]) {
                rg.get(y).add(x);
            }
            inDeg[x] = graph[x].length;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int y = queue.poll();
            for (int x : rg.get(y)) {
                if (--inDeg[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

   
    public List<Integer> eventualSafeNodes1(int[][] graph) {
        int n = graph.length;
        List<Integer> result = new ArrayList<>(n);
        // 0节点尚未被访问  1处于环中或递归栈中 2安全节点
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (safe(graph, color, i)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }

    public static void main(String[] args) {
        FindEventualSafeStates fess = new FindEventualSafeStates();
        System.out.println(fess.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}})); // 2,4,5,6
        System.out.println(fess.eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}));//4
    }
}
