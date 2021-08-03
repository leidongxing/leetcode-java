package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/8/3
 * 最短无序连续子数组
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(tmp);
        int left = 0;
        int right = nums.length - 1;
        while (tmp[left] == nums[left]) {
            left++;
        }
        while (tmp[right] == nums[right]) {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
