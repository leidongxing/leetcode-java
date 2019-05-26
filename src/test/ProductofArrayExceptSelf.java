package test;

import java.util.HashSet;
import java.util.Set;

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                s.add(i);
            } else {
                sum = sum * nums[i];
            }
        }

        int[] result = new int[nums.length];
        if (s.isEmpty()) {
            for (int j = 0; j < result.length; j++) {
                result[j] = sum / nums[j];
            }
        } else if (s.size() >= 2) {
            for (int k = 0; k < result.length; k++) {
                result[k] = 0;
            }
        } else {
            for (int m = 0; m < result.length; m++) {
                if (s.contains(m)) {
                    result[m] = sum;
                } else {
                    result[m] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf t = new ProductofArrayExceptSelf();
//			t.productExceptSelf(new int[] {1,2,3,4});
        t.productExceptSelf(new int[]{1, 0});
    }
}
