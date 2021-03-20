package test;

/**
 * @author LeiDongxing
 * created on 2021/3/20
 * 十-二进制数的最少数目
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public int minPartitions(String n) {
        int result = 1;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != '1' && n.charAt(i) != 0) {
                result = Math.max(result, n.charAt(i) - '0');
            }
        }
        return result;
    }
}
