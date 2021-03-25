package test;

/**
 * @author LeiDongxing
 * created on 2021/3/25
 * 整数的各位积和之差
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        if (n <= 9) {
            return 0;
        }
        //和
        int p1 = 0;
        //积
        int p2 = 1;

        while (n > 9) {
            p1 += n % 10;
            p2 *= (n % 10);
            n = n / 10;
        }
        return (p2 * n) - p1 - n;
    }

    public static void main(String[] args) {
        SubtractTheProductAndSumOfDigitsOfAnInteger s = new SubtractTheProductAndSumOfDigitsOfAnInteger();
        System.out.println(s.subtractProductAndSum(234));
        System.out.println(s.subtractProductAndSum(4421));
    }
}
