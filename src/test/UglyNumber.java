package test;

public class UglyNumber {

    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        } else if (num == 0) {
            return false;
        }

        while (num % 2 == 0) {
            num = num >> 1;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        UglyNumber un = new UglyNumber();
        // System.out.println(un.isUgly(14));
        // System.out.println(un.isUgly(1));
        // System.out.println(un.isUgly(7));
        System.out.println(un.isUgly(10));
    }
}
