package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = nums.length - 1; j > 2; j--) {
                    if (j == nums.length - 1 || nums[j] != nums[j + 1]) {
                        int lo = i + 1, hi = j - 1, sum = target - nums[i] - nums[j];
                        while (lo < hi) {
                            if (nums[lo] + nums[hi] == sum) {
                                res.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]));
                                while (lo < hi && nums[lo] == nums[lo + 1])
                                    lo++;
                                while (lo < hi && nums[hi] == nums[hi - 1])
                                    hi--;
                                lo++;
                                hi--;
                            } else if (nums[lo] + nums[hi] < sum)
                                lo++;
                            else
                                hi--;
                        }
                    }

                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum f = new FourSum();
        List<List<Integer>> list1 = f.fourSum(new int[]{0, 0, 0, 0}, 0);
        for (List<Integer> list : list1) {
            System.out.print("[");
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println("]");
        }
    }
}
