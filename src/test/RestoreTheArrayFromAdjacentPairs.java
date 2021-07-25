package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/7/25
 * 从相邻元素对还原数组
 */
public class RestoreTheArrayFromAdjacentPairs {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }


        int n = adjacentPairs.length + 1;
        int[] result = new int[n];

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1) {
                result[0] = e;
                break;
            }
        }

        result[1] = map.get(result[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = map.get(result[i - 1]);
            result[i] = result[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }

        return result;
    }
}
