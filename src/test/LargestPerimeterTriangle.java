package test;

import java.util.Arrays;

/**
 * 三角形的最大周长
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }


    public int largestPerimeter2(int[] A) {
        quickSort(A, 0, A.length - 1);
        int i = 0, j = 1, k = 2;
        while (i < A.length - 2) {
            while (k < A.length) {
                if (A[i] < A[j] + A[k]) {
                    return A[i] + A[j] + A[k];
                }
                k++;
            }
            i++;
            j++;
            k = j + 1;
        }
        return 0;
    }

    int[] quickSort(int[] A, int left, int right) {
        int p = 0;
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
        return left;
    }

    public int largestPerimeter1(int[] A) {
        Arrays.sort(A);
        int i = A.length - 1, j = A.length - 2, k = A.length - 3;
        while (i >= 2) {
            while (k >= 0) {
                if (A[i] < A[j] + A[k]) {
                    return A[i] + A[j] + A[k];
                }
                k--;
            }
            i--;
            j--;
            k = j - 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        LargestPerimeterTriangle l = new LargestPerimeterTriangle();
        System.out.println(l.largestPerimeter1(new int[]{1, 2, 1}));
    }
}


