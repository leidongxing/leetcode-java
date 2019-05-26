package test;

public class Powxn {
    public double myPow(double x, int n) {
        // return Math.pow(x,n);
        double temp = x;
        if (n == 0) {
            return 1;
        }
        temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return x * temp * temp;
            } else {
                return (temp * temp) / x;
            }
        }
    }

    public static void main(String[] args) {
        Powxn p = new Powxn();
        System.out.println(p.myPow(2, 3));
    }
}
