package test;

public class NthMagicalNumber {
    public int nthMagicalNumber1(int N, int A, int B) {
        int times = 0;
        int start = Math.min(A, B);
        while (times < N) {
            if (start % A == 0 || start % B == 0) {
                times++;
            }
            start++;
        }
        return start - 1;
    }

    public int nthMagicalNumber2(int N, int A, int B) {
        if (A == B) {
            long result = (long) A * (long) N;
            if (result > Integer.MAX_VALUE) {
                return (int) (result % ((long) Math.pow(10, 9) + 7));
            } else {
                return (int) result;
            }
        }
        long aPair = 1;
        long bPair = 1;
        int times = 0;
        long n = 0;
        while (true) {
            if (aPair * A < bPair * B) {
                n = aPair * A;
                times++;
                aPair++;
            } else if (aPair * A > bPair * B) {
                n = bPair * B;
                times++;
                bPair++;
            } else {
                n = aPair * A;
                aPair++;
                bPair++;
                times++;
            }
            if (times == N) {
                break;
            }

        }
        if (n > Integer.MAX_VALUE) {
            return (int) (n % ((long) Math.pow(10, 9) + 7));
        } else {
            return (int) n;
        }
    }


    //best
    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1_000_000_007;
        int L = A / gcd(A, B) * B;

        long lo = 0;
        long hi = (long) 1e15;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            if (mi / A + mi / B - mi / L < N)
                lo = mi + 1;
            else
                hi = mi;
        }

        return (int) (lo % MOD);
    }

    //mod
    public int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

    public static void main(String[] args) {
        NthMagicalNumber n = new NthMagicalNumber();
        // System.out.println(n.nthMagicalNumber(1, 2, 3));
        // System.out.println(n.nthMagicalNumber(4, 2, 3));
        // System.out.println(n.nthMagicalNumber(7, 5, 8));
        // System.out.println("---"+n.nthMagicalNumber(5, 2, 4));
        // System.out.println(n.nthMagicalNumber(1000000000, 40000, 40000));
        System.out.println(n.nthMagicalNumber(852810511, 9767, 25276));
        System.out.println(n.gcd(10, 3));
        // System.out.println(Integer.MAX_VALUE);
        // System.out.println((long)1000000000*(long)40000);
        // System.out.println((long)Math.pow(10, 9)+7);
    }
}
