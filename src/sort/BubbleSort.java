package sort;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/8/19
 * 冒泡排序
 */
public class BubbleSort {
    public int[] bubbleSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] < A[j + 1]) {
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
            System.out.println(Arrays.toString(A));
        }
        return A;
    }

    public static void main(String[] args) {
        BubbleSort q = new BubbleSort();
        int[] nums = new int[]{22, 121, 8, 6, 23, 10, 1, -3, 5, 59, 6, 7};

        System.out.println(Arrays.toString(q.bubbleSort(nums)));
    }
}
