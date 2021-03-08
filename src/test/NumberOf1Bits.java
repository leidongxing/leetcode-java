package test;

/**
 * @author LeiDongxing
 * created on 2021/3/8
 * 位1的个数
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int bits = 0;
        //0000 0000 0000 0000 0000 0000 0000 0001
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            //任何数字与掩码1进行逻辑与 都可以获取最低位
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
}
