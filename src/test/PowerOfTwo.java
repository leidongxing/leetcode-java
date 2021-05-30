package test;

/**
 * 2的幂
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo1(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        }
        while (n > 2) {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return n == 2;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo p = new PowerOfTwo();
        System.out.println(p.isPowerOfTwo(10));
        System.out.println(p.isPowerOfTwo(16));
        System.out.println(p.isPowerOfTwo(14));
        System.out.println(p.isPowerOfTwo(6));
    }
}
