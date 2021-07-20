package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/7/20
 * 数组中最大数对和的最小值
 */
public class MinimizeMaximumPairSumInArray {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(nums[left] + nums[right], max);
            left++;
            right--;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MinimizeMaximumPairSumInArray().minPairSum(new int[]{3, 5, 2, 3}));//2 3 3 5  =7
        System.out.println(new MinimizeMaximumPairSumInArray().minPairSum(new int[]{3, 5, 4, 2, 4, 6}));//2,3,4,4,5,6 =8
        System.out.println(new MinimizeMaximumPairSumInArray().minPairSum(new int[]{4, 1, 5, 1, 2, 5, 1, 5, 5, 4}));//1, 1, 1, 2, 4, 4, 5, 5, 5, 5  =8
    }
}
