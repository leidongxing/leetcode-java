package sort;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/6/7
 * 快速排序
 */
public class QuickSort {
    public int[] quickSort(int[] A, int left, int right) {
        int p;
        if (left < right) {
            p = partition(A, left, right);
            quickSort(A, left, p - 1);
            quickSort(A, p + 1, right);
        }
        return A;
    }

    int partition(int[] A, int left, int right) {
        int key = A[left];
        while (left < right) {
            while (left < right && A[right] <= key) {
                right--;
            }
            A[left] = A[right];
            while (left < right && A[left] >= key) {
                left++;
            }
            A[right] = A[left];
        }
        A[left] = key;
        System.out.println(Arrays.toString(A));
        return left;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] nums = new int[]{22, 121, 8, 6, 23, 10, 1, -3, 5, 59, 6, 7};
        //[59, 121, 23, 22, 6, 10, 1, -3, 5, 8, 6, 7]
        //[121, 59, 23, 22, 6, 10, 1, -3, 5, 8, 6, 7]
        //[121, 59, 23, 22, 7, 10, 8, 6, 5, -3, 6, 1]
        //[121, 59, 23, 22, 8, 10, 7, 6, 5, -3, 6, 1]
        //[121, 59, 23, 22, 10, 8, 7, 6, 5, -3, 6, 1]
        //[121, 59, 23, 22, 10, 8, 7, 6, 6, 5, -3, 1]
        //[121, 59, 23, 22, 10, 8, 7, 6, 6, 5, 1, -3]
        //[121, 59, 23, 22, 10, 8, 7, 6, 6, 5, 1, -3]
        System.out.println(Arrays.toString(q.quickSort(nums, 0, nums.length - 1)));
    }
}
