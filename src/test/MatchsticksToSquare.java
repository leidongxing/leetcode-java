package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/1/30
 * 火柴拼正方形
 */
public class MatchsticksToSquare {
    // 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum == 0 || sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        int side = sum / 4;
        if (nums[nums.length - 1] > side) {
            return false;
        } else {
            boolean[] used = new boolean[nums.length];
            for (int i = 0; i < 3; i++) {
                if (!dfs(nums, side, used)) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean dfs(int[] nums, int target, boolean[] used) {
        if (target == 0) {
            return true;
        } else if (target < 0) {
            return false;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!used[i]) {
                used[i] = true;
                boolean result = dfs(nums, target - nums[i], used);
                if (!result) {
                    used[i] = false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        MatchsticksToSquare m = new MatchsticksToSquare();
        System.out.println(m.makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(m.makesquare(new int[]{3, 3, 3, 3, 4}));
        System.out.println(m.makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3})); //48 /12
    }
}
