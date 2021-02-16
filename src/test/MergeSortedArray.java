package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/2/16
 * 合并两个有序数组
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        //从后到前 先确定最后位置的数字
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;
        while (i >= 0) {
            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] > nums2[p2]) {
                    nums1[i] = nums1[p1];
                    p1--;
                } else {
                    nums1[i] = nums2[p2];
                    p2--;
                }
                i--;
            } else if (p1 >= 0) {
                nums1[i] = nums1[p1];
                p1--;
                i--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
                i--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
        m.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        m.merge(new int[]{1, 2, 3, 0, 0}, 3, new int[]{7, 8, 10}, 2);
        m.merge(new int[]{19, 20, 322, 0, 0, 0}, 3, new int[]{7, 8, 10}, 3);
    }
}
