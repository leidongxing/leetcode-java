package test;

/**
 * 单调数列
 */
public class MonotonicArray {
    public boolean isMonotonic1(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                inc = false;
            }
            if (A[i] < A[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }

    public boolean isMonotonic(int[] A) {
        return increasing(A) || decreasing(A);
    }

    public boolean increasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean decreasing(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MonotonicArray m = new MonotonicArray();
        System.out.println(m.isMonotonic(new int[]{2, 1}));
        System.out.println(m.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(m.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(m.isMonotonic(new int[]{1, 3, 2}));
        System.out.println(m.isMonotonic(new int[]{1, 1, 1}));
        System.out.println(m.isMonotonic(new int[]{1, 5, 4, 6, 7, 8, 9}));
        System.out.println(m.isMonotonic(new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println(m.isMonotonic(new int[]{1, 1, 1, 1, 1, 2}));
        System.out.println(m.isMonotonic(new int[]{1, 2, 5, 3, 3}));
    }
}
