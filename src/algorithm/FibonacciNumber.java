package algorithm;

public class FibonacciNumber {
    public int fib1(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    public int fib(int N) {
        int i = 0;
        int j = 1;
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }
        int times = 2;
        int sum = 2;
        while (times <= N) {
            sum = i + j;
            i = j;
            j = sum;
            times++;
        }
        return sum;
    }

    public static void main(String[] args) {
        FibonacciNumber f = new FibonacciNumber();
        System.out.println(f.fib(10));
    }
}
