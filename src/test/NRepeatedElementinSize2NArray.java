package test;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] A) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int i = 0; i <= A.length / 2 + 1; i++) {
            if (numSet.contains(A[i])) {
                return A[i];
            }
            numSet.add(A[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        NRepeatedElementinSize2NArray n = new NRepeatedElementinSize2NArray();
        System.out.println(n.repeatedNTimes(new int[]{1, 2, 3, 3}));
    }
}
