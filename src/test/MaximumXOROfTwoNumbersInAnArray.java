package test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LeiDongxing
 * created on 2021/5/16
 * 数组中两个数的最大异或值
 */
public class MaximumXOROfTwoNumbersInAnArray {
    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums) {
                seen.add(num >> k);
            }
            int xNext = x * 2 + 1;
            boolean found = false;

            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            if (found) {
                x = xNext;
            } else {
                x = xNext - 1;
            }
        }
        return x;
    }

    //暴力破解
    public int findMaximumXOR1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumXOROfTwoNumbersInAnArray m = new MaximumXOROfTwoNumbersInAnArray();
        System.out.println(m.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));//28
        System.out.println(m.findMaximumXOR(new int[]{0}));//0
        System.out.println(m.findMaximumXOR(new int[]{2, 4}));//6
        System.out.println(m.findMaximumXOR(new int[]{8, 10, 2})); //10
        System.out.println(m.findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70})); //127
    }

}
