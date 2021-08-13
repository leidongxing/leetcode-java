package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/3/31
 * 子集 II
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(false, 0, nums, new ArrayList<>(), result);
        return result;
    }

    private void dfs(boolean choosePre, int start, int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        dfs(false, start + 1, nums, list, result);
        if (!choosePre && start > 0 && nums[start - 1] == nums[start]) {
            return;
        }
        list.add(nums[start]);
        dfs(true, start + 1, nums, list, result);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        SubsetsII s = new SubsetsII();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
