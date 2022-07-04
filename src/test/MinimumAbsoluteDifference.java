package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2022/7/4
 * 最小绝对差
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int best = Integer.MAX_VALUE;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int delta = arr[i + 1] - arr[i];
            if (delta < best) {
                best = delta;
                result.clear();
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                result.add(pair);
            } else if (delta == best) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                result.add(pair);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifference m = new MinimumAbsoluteDifference();
        System.out.println(m.minimumAbsDifference(new int[]{4, 2, 1, 3}));//[[1,2],[2,3],[3,4]]
        System.out.println(m.minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));//[[1,3]]
        System.out.println(m.minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));//[[-14,-10],[19,23],[23,27]]
    }
}