package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 数组中出现次数超过一半的数字
 */
public class MajorityElement {

    /**
     * 摩尔投票法 给每个数投票
     * 是候选人+1 不是候选-1
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    /**
     * 分治查找
     * 如果数a是数组 nums 的众数，将 nums 分成两部分，那么a必定是至少一部分的众数。
     */
    public int majorityElement1(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 随机寻找
     */
    public int majorityElement2(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * 排序法
     */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * hash计数法
     */
    public int majorityElement4(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> num2times = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (num2times.containsKey(nums[i])) {
                int times = num2times.get(nums[i]);
                if (times + 1 > nums.length / 2) {
                    return nums[i];
                } else {
                    num2times.put(nums[i], times + 1);
                }
            } else {
                num2times.put(nums[i], 1);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(new int[] {3,2,3}));
        System.out.println(me.majorityElement(new int[] {2,2,1,1,1,2,2}));
        System.out.println(me.majorityElement(new int[] {10,9,9,9,10}));
        System.out.println(me.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
