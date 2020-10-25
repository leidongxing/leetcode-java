package test;

/**
 * @author LeiDongxing
 * created on 2020/10/25
 * 数组中的最长山脉
 */
public class LongestMountainInArray {
    public int longestMountain(int[] A) {
        int n = A.length;
        if (A.length == 0) {
            return 0;
        }
        int[] left = new int[n];
        //从左往右 要依次单调递增
        for (int i = 1; i < n; i++) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }

        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            //左右两边均大于0
            if (left[i] > 0 && right[i] > 0) {
                //返回山顶长度
                max = Math.max(max, left[i] + right[i] + 1);
            }
        }
        return max;
    }
}
