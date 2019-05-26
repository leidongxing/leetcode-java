package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int a : A) {
            for (int b : B) {
                m.put(a + b, m.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                res += m.getOrDefault(-c - d, 0);
            }
        }
        return res;
    }

    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        if (A.length == 0 || A[0] + B[0] + C[0] + D[0] > 0) {
            return 0;
        }

        if (A[A.length - 1] + B[B.length - 1] + C[C.length - 1] + D[D.length - 1] < 0) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] + B[0] + C[0] + D[0] > 0) {
                return sum;
            } else if (A[i] + B[B.length - 1] + C[C.length - 1] + D[D.length - 1] < 0) {
                continue;
            }
            for (int j = 0; j < B.length; j++) {
                if (A[i] + B[j] + C[0] + D[0] > 0) {
                    break;
                } else if (A[i] + B[j] + C[C.length - 1] + D[D.length - 1] < 0) {
                    continue;
                }
                for (int m = 0; m < C.length; m++) {
                    if (A[i] + B[j] + C[m] + D[0] > 0) {
                        break;
                    } else if (A[i] + B[j] + C[m] + D[D.length - 1] < 0) {
                        continue;
                    }
                    for (int n = 0; n < D.length; n++) {
                        if (A[i] + B[j] + C[m] + D[n] == 0) {
                            sum++;
                        } else if (A[i] + B[j] + C[m] + D[n] > 0) {
                            break;
                        } else if (A[i] + B[j] + C[m] + D[D.length - 1] < 0) {
                            continue;
                        }

                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        FourSumII f = new FourSumII();
        System.out.println(
                f.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
