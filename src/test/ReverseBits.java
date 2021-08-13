package test;

/**
 * @author LeiDongxing
 * created on 2021/2/16
 * 颠倒二进制位
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += 1 & n;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        System.out.println(r.reverseBits(1));
    }
}
