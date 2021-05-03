package test;

/**
 * 整数反转
 */
public class ReverseInteger implements Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            } else {
                int digit = x % 10;
                x /= 10;
                result = result * 10 + digit;
            }
        }
        return result;
    }

    public int reverse1(int x) {
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        if (r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE) {
            return (int) r;
        } else {
            return 0;
        }
    }


    @Override
    public void doIt() {
        System.out.println(this.reverse(123)); // 321
        System.out.println(this.reverse(-123)); // -321
        System.out.println(this.reverse(1000000003)); // 3000000001 0
        System.out.println(this.reverse(-2147483648));
    }

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        new ClacTimeThread(r).start();
    }
}
