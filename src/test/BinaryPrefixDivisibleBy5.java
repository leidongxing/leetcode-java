package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/1/14
 * 可被5整除的二进制前缀
 */
public class BinaryPrefixDivisibleBy5 {
    /**
     * 模运算法则
     * 1. (a + b) % p = (a % p + b % p) % p
     * 2. (a - b) % p = (a % p - b % p) % p
     * 3. (a * b) % p = (a % p * b % p) % p
     * 4. (a^b) % p = ((a % p)^b) % p
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int prefix = 0;
        for (int j : A) {
            //<< 左移1位  扩大1倍
            prefix = ((prefix << 1) + j) % 5;
            //直接比较最后一位
            result.add(prefix == 0);
        }
        return result;
    }

    /**
     * long溢出会报错
     */
    public List<Boolean> prefixesDivBy51(int[] A) {
        List<Boolean> result = new ArrayList<>(A.length);
        long pre = A[0];
        result.add(pre == 0);
        for (int i = 1; i < A.length; i++) {
            long current = pre * 2 + A[i];
            if (current % 5 == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
            pre = current;
        }
        return result;
    }


}
