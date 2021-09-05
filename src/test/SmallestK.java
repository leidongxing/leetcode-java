package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/9/3
 * 最小K个数
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public void quickSort(int[] arr, int left, int right, int k) {
        if (left < right) {
            int p = partition(arr, left, right);
            if (p < k) {
                quickSort(arr, p + 1, right, k);
            } else if (p > k) {
                quickSort(arr, left, p - 1, k);
            }
        }
    }


    public int partition(int[] arr, int left, int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] > key) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] < key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }


    public static void main(String[] args) {
        SmallestK smallestK = new SmallestK();
        System.out.println(Arrays.toString(smallestK.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 8)));
    }
}
