package test;

/**
 * @author LeiDongxing
 * created on 2021/2/27
 * 合并排序的数组
 */
public class SortedMergeLCCI {
    /**
     * @param A 有足够空间容纳B
     * @param m A的真实长度
     * @param B 数组B
     * @param n B的长度
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int pA = m - 1;
        int pB = n - 1;
        int p = A.length - 1;
        while (pA >= 0 && pB >= 0) {
            if (A[pA] < B[pB]) {
                A[p] = B[pB];
                pB--;
            } else {
                A[p] = A[pA];
                pA--;
            }
            p--;
        }
        while (pA >= 0) {
            A[p] = A[pA];
            pA--;
            p--;
        }
        while (pB >= 0) {
            A[p] = B[pB];
            pB--;
            p--;
        }
    }

    public static void main(String[] args) {
        SortedMergeLCCI s = new SortedMergeLCCI();
        s.merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
