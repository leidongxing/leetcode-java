package test;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> minset = new HashSet<Integer>();
        int[] max;
        if (nums1.length > nums2.length) {
            for (int i = 0; i < nums2.length; i++) {
                minset.add(nums2[i]);
            }
            max = nums1;
        } else {
            for (int i = 0; i < nums1.length; i++) {
                minset.add(nums1[i]);
            }
            max = nums2;
        }

        Set<Integer> resultset = new HashSet<Integer>();
        for (int j = 0; j < max.length; j++) {
            if (minset.contains(max[j])) {
                resultset.add(max[j]);
            }
        }
        int[] result = new int[resultset.size()];
        int index = 0;
        for (int s : resultset) {
            result[index] = s;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        IntersectionofTwoArrays ioft = new IntersectionofTwoArrays();
        System.out.println(ioft.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
        System.out.println(ioft.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }
}
