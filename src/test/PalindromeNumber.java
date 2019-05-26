package test;

public class PalindromeNumber implements Solution {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    @Override
    public void doIt() {
        System.out.println(this.isPalindrome(1));
        System.out.println(this.isPalindrome(11221));
        System.out.println(this.isPalindrome(-2147447412));
        System.out.println(this.isPalindrome(11));

    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        new ClacTimeThread(p).run();
    }

}
