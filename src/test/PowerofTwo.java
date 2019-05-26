package test;

public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
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
        if (n == 2) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        PowerofTwo p = new PowerofTwo();
        System.out.println(p.isPowerOfTwo(10));
        System.out.println(p.isPowerOfTwo(16));
        System.out.println(p.isPowerOfTwo(14));
        System.out.println(p.isPowerOfTwo(6));
    }
}
