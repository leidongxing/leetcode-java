package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/3/24
 * 幂集
 */
public class PowerSetLCCI {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            dfs(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        PowerSetLCCI p = new PowerSetLCCI();
        System.out.println(p.subsets(new int[]{1, 2, 3}));
    }
}
