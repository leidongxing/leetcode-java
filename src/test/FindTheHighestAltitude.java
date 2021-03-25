package test;

/**
 * @author LeiDongxing
 * created on 2021/3/25
 * 找到最高海拔
 */
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int pre = 0;
        for (int i = 0; i < gain.length; i++) {
            pre += gain[i];
            max = Math.max(pre, max);
        }
        return max;
    }
}
