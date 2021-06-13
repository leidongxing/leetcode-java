package test;

/**
 * @author LeiDongxing
 * created on 2021/6/14
 * 猜数字大小
 */
public class GuessNumberHigherOrLower {
    private int guess(int n){
        return -1;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
