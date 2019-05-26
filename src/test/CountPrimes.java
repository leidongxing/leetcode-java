package test;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }

    public int countPrimes1(int n) {
        if (n < 2) {
            return 0;
        }
        byte bytes[] = new byte[n];
        int k = 2, t = 0;
        while (t < n) {
            for (int i = 1; i < bytes.length; i++) {
                if (i % k == 0 && i != k) {
                    bytes[i] = 1;
                }
            }
            for (int i = 1; i < bytes.length; i++) {
                if (i > k && bytes[i] == 0) {
                    k = i;
                    break;
                }
                t++;
            }
        }
        int sum = 0;
        for (int i = 2; i < bytes.length; i++) {
            if (bytes[i] == 0) {
                sum++;
            }
        }
        return sum;
    }

    // sieve of Eratosthenes
    void findPrime(int n) {
        byte bytes[] = new byte[n + 1];
        bytes[2] = 0;
        int k = 2, t = 0;
        while (t < n + 1) {
            for (int i = 1; i < bytes.length; i++) {
                if (i % k == 0 && i != k) { // 将不是素数的数筛出
                    bytes[i] = 1;
                }
            }
            for (int i = 1; i < bytes.length; i++) {
                if (i > k && bytes[i] == 0) {
                    k = i; // 将筛选后的第一个数当做新的筛子
                    break;
                }
                t++;
            }
        }
        for (int i = 2; i < bytes.length; i++) {
            if (bytes[i] == 0) {
                System.out.printf("%d ", i);
            }
        }
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }
}
