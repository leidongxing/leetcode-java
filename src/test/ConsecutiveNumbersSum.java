package test;

public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int sum = 0;
        int s = 0;
        for (int i = N; i > 0; i--) {

            sum++;
        }
        return sum;
    }
}
