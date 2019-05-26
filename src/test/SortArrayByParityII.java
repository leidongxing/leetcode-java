package test;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int[] nA = new int[A.length];
        int eI = 0, oI = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                nA[eI] = A[i];
                eI += 2;
            } else {
                nA[oI] = A[i];
                oI += 2;
            }
        }
        return nA;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        sortArrayByParityII.sortArrayByParityII(new int[]{4, 2, 5, 7});
    }
}
