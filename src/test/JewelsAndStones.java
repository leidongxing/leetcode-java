package test;

import java.util.HashSet;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }

        char[] j = J.toCharArray();
        char[] s = S.toCharArray();
        HashSet<Character> jSet = new HashSet<Character>();
        int sum = 0;
        for (char i : j) {
            jSet.add(i);
        }
        for (char i : s) {
            if (jSet.contains(i)) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        JewelsAndStones jaStones = new JewelsAndStones();
        System.out.println(jaStones.numJewelsInStones("aA", "aAAbbbb"));
    }
}
