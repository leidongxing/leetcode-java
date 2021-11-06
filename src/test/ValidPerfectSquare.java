package test;

/**
 * @author LeiDongxing
 * created on 2021/11/4
 * 有效的完全平方数
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int tmp = mid * mid;
            if (tmp == num) {
                return true;
            } else if (tmp < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
