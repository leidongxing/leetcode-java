package test;

/**
 * @author LeiDongxing
 * created on 2022/6/3
 * 连续整数求和
 */
public class ConsecutiveNumbersSum {
    /**
     * 等差数列 (a+a+k)*(k+1)/2=N    (a+a+k)*(k+1)=2N
     * a+..+a+k 等价于 1+..k+1 +(k+1)*(a-1)/2 等价于 1+..k+k*i =2N
     *
     * @param N
     * @return
     */
    public int consecutiveNumbersSum(int N) {
        int sum = 0;
        int end = N << 1;
        for (int k = 1; k * k <= end; k++) {
            if ((N - (1 + k) * k / 2) % k == 0) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ConsecutiveNumbersSum c = new ConsecutiveNumbersSum();
        System.out.println(c.consecutiveNumbersSum(5)); //2+3 5    =2
        System.out.println(c.consecutiveNumbersSum(9)); //2+3+4 4+5 9   =3
        System.out.println(c.consecutiveNumbersSum(15)); //8+7 4+5+6 1+2+3+4+5 15  =4
    }
}
