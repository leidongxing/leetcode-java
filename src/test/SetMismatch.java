package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/7/4
 * 错误的集合
 */
public class SetMismatch {
    /**
     * 找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回
     */
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (cur == prev) {
                //重复元素
                result[0] = prev;
            } else if (cur - prev > 1) {
                result[1] = prev + 1;
            }
            prev = cur;
        }
        if (nums[n - 1] != n) {
            result[1] = n;
        }
        return result;
    }
}
