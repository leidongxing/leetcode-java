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


