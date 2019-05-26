package test;

public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK1(int[] A, int K) {
        int counts = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = A[i];
            if (sum % K == 0) {
                counts++;
            }
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                if (sum % K == 0) {
                    counts++;
                }
            }
        }
        return counts;
    }

    public int subarraysDivByK(int[] A, int K) {
        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + A[i];

        int[] count = new int[K];
        for (int x : P)
            count[(x % K + K) % K]++;

        int ans = 0;
        for (int v : count)
            ans += v * (v - 1) / 2;
        return ans;
    }

    public static void main(String[] args) {
        SubarraySumsDivisiblebyK s = new SubarraySumsDivisiblebyK();
        System.out.println(s.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
