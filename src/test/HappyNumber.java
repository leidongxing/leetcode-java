package test;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> s = new HashSet<Integer>();
        while (sum != 1) {
            while (n >= 10) {
                int x = n % 10;
                sum += x * x;
                n = n / 10;
            }
            sum += n * n;
            if (s.contains(sum)) {
                if (sum == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                s.add(sum);
            }
            n = sum;
            sum = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(19));//true
        System.out.println(h.isHappy(2147483645));//true
        System.out.println(h.isHappy(1)); //true
        System.out.println(h.isHappy(2)); //false
        System.out.println(h.isHappy(3)); //false
        System.out.println(h.isHappy(4)); //false
        System.out.println(h.isHappy(5)); //false
        System.out.println(h.isHappy(6)); //false
        System.out.println(h.isHappy(7)); //true
        System.out.println(h.isHappy(8)); //false
        System.out.println(h.isHappy(9)); //false
//		System.out.println(Integer.MAX_VALUE);

    }
}
