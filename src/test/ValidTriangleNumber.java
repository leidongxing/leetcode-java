package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/8/4
 * 有效三角形的个数
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int result = 0;
        int left = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {

            }
        }


        int right = nums.length - 1;
        int tmp = right - 1;
        while (left < right) {
            while (nums[left] + nums[tmp] > nums[right]) {
                tmp--;
                result++;
            }
            right--;
        }
        return result;
    }
}
