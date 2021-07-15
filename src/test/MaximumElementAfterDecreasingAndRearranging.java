package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/7/15
 * 减小和重新排列数组后的最大元素
 */
public class MaximumElementAfterDecreasingAndRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        //arr中第一个元素必须为1
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[arr.length - 1];
    }
}
