package test;

/**
 * @author LeiDongxing
 * created on 2021/10/10
 * 排列硬币
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int arrangeCoins1(int n) {
        int result = 1;
        while (true) {
            if (n < result) {
                return result - 1;
            }
            n -= result;
            result++;
        }
    }


    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(5));//2
        System.out.println(new ArrangingCoins().arrangeCoins(45));//9  1 2 3 4   10   26 5 6 7 8 9
    }
}
