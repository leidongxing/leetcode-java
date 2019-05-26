package test;

import java.util.Arrays;


public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int solution = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum < target) {
                        if (Math.abs(solution - target) > Math.abs(sum - target)) {
                            solution = sum;
                        }
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        lo++;
                    } else if (sum > target) {
                        if (Math.abs(solution - target) > Math.abs(sum - target)) {
                            solution = sum;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        hi--;

                    } else {
                        return target;
                    }
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int i = new ThreeSumClosest().threeSumClosest(new int[]{1, 1, 1, 0}, -100);
        System.out.println(i);
    }
}
