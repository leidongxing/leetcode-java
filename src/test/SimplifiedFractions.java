package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2022/2/10
 * 最简分数
 */
public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>(8);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(j, i) == 1) {
                    result.add(j + "/" + i);
                }
            }
        }
        return result;
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        SimplifiedFractions s=new SimplifiedFractions();
        System.out.println(s.simplifiedFractions(2));
        System.out.println(s.simplifiedFractions(3));
        System.out.println(s.simplifiedFractions(1));
    }
}
