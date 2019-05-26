package test;

public class Sqrtx {
    public int mySqrt(int x) {
//      return (int)Math.sqrt(x);
        if (x == 0) {
            return 0;
        }
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Sqrtx s = new Sqrtx();
        System.out.println(s.mySqrt(16));
        System.out.println(s.mySqrt(8));

    }
}
