package test;

public class ReverseInteger implements Solution {
    public int reverse(int x) {
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        if (r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE)
            return (int) r;
        else
            return 0;
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
        new ClacTimeThread(r).run();
    }
}
