package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/7/26
 * 得到子序列的最少操作次数
 */
public class MinimumOperationsToMakeASubsequence {
    /**
     * @param target 互不相同的整数
     * @param arr    可能包含重复元素
     * @return 最少操作次数 使target成为arr的一个子序列
     */
    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            pos.put(target[i], i);
        }
        List<Integer> d = new ArrayList<>();
        for (int val : arr) {
            if (pos.containsKey(val)) {
                int idx = pos.get(val);
                int it = binarySearch(d, idx);
                if (it != d.size()) {
                    d.set(it, idx);
                } else {
                    d.add(idx);
                }
            }
        }
        return n - d.size();
    }

    public int binarySearch(List<Integer> d, int target) {
        int size = d.size();
        if (size == 0 || d.get(size - 1) < target) {
            return size;
        }
        int low = 0, high = size - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (d.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        MinimumOperationsToMakeASubsequence m = new MinimumOperationsToMakeASubsequence();
        System.out.println(m.minOperations(new int[]{5, 1, 3}, new int[]{9, 4, 2, 3, 4}));//2
        System.out.println(m.minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1}));//3
    }
}
