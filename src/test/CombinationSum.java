package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总数
 * 返回所有的解 十有八九都要用递归
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
//
//        for(int i=0;i<candidates.length;i++){
//            combinationSum(target-nums[i]);
//        }
//
//
//        result.add(al);

    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, result, combine, 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combine, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combine));
            return;
        }
        //不使用index位置的数字
        dfs(candidates, target, result, combine, index + 1);
        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            //继续使用index位置的数字
            dfs(candidates, target - candidates[index], result, combine, index);
            combine.remove(combine.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 5, 4};
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(nums, 7));
    }
}
