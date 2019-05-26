package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> min2times = new HashMap<Integer, Integer>();
        int[] max;
        if (nums1.length > nums2.length) {
            for (int i = 0; i < nums2.length; i++) {
                if (min2times.containsKey(nums2[i])) {
                    min2times.put(nums2[i], min2times.get(nums2[i]) + 1);
                } else {
                    min2times.put(nums2[i], 1);
                }
            }
            max = nums1;
        } else {
            for (int i = 0; i < nums1.length; i++) {
                if (min2times.containsKey(nums1[i])) {
                    min2times.put(nums1[i], min2times.get(nums1[i]) + 1);
                } else {
                    min2times.put(nums1[i], 1);
                }
            }
            max = nums2;
        }

        List<Integer> resultlist = new ArrayList<Integer>();
        for (int j = 0; j < max.length; j++) {
            if (min2times.containsKey(max[j]) && min2times.get(max[j]) != 0) {
                resultlist.add(max[j]);
                min2times.put(max[j], min2times.get(max[j]) - 1);
            }
        }
        int[] result = new int[resultlist.size()];
        int index = 0;
        for (int s : resultlist) {
            result[index] = s;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        IntersectionofTwoArraysII ioftII = new IntersectionofTwoArraysII();
        ioftII.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        ioftII.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }
}
