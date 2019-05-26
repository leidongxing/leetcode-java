package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RotatedDigits {
    public int rotatedDigits(int N) {
        Set<Integer> invalidSet = new HashSet<Integer>();
        invalidSet.add(3);
        invalidSet.add(4);
        invalidSet.add(7);

        Set<Integer> sameSet = new HashSet<Integer>();
        sameSet.add(0);
        sameSet.add(1);
        sameSet.add(8);

        Map<Integer, Integer> rotateMap = new HashMap<Integer, Integer>();
        rotateMap.put(2, 5);
        rotateMap.put(5, 2);
        rotateMap.put(6, 9);
        rotateMap.put(9, 6);

        int sum = 0;

        for (int i = 0; i <= N; i++) {
            if (i < 10) {
                if (!invalidSet.contains(i) && !sameSet.contains(i)) {
                    sum++;
                }
            } else if (i < 100) {
                int s = i % 10;
                int g = i - 10 * s;
                if (invalidSet.contains(i) || s == g) {
                    continue;
                } else {
                    sum++;
                }
            } else if (i < 1000) {
                int b = i % 100;
                int s = i % 10;
                int g = i - 10 * s;
                if (invalidSet.contains(i) || s == g) {
                    continue;
                } else {
                    sum++;
                }

            } else if (i < 10000) {
                int q = i % 1000;
                int b = i % 100;
                int s = i % 10;
                int g = i - 10 * s;
                if (invalidSet.contains(i) || s == g) {
                    continue;
                } else {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RotatedDigits rd = new RotatedDigits();
        rd.rotatedDigits(10);
    }

}
