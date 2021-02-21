package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/2/21
 * 绝对差不超过限制的最长连续子数组
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    /**
     * 滑动窗口
     */
    public int longestSubarray(int[] nums, int limit) {
        //维护最大值 递减队列
        Deque<Integer> queMax = new LinkedList<>();
        //维护最小值 递增队列
        Deque<Integer> queMin = new LinkedList<>();
        int left = 0, right = 0;
        int result = 0;
        while (right < nums.length) {
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            queMax.offerLast(nums[right]);

            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMin.offerLast(nums[right]);

            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (nums[left] == queMin.peekFirst()) {
                    queMin.pollFirst();
                }
                if (nums[left] == queMax.peekFirst()) {
                    queMax.pollFirst();
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }


    /**
     * 滑动窗口 有序队列
     */
    public int longestSubarray2(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0;
        int result = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            //超过限制 左边界收缩
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }


    /**
     * 暴力法  列出所有的组合
     */
    public int longestSubarray1(int[] nums, int limit) {
        int result = 0;
        int left = 0;
        while (left < nums.length) {
            result = Math.max(result, find(nums, left, limit));
            left++;
        }
        return result;
    }

    private int find(int[] nums, int start, int limit) {
        int result = 0;
        int right = start;
        while (start < nums.length) {
            while (right < nums.length) {
                List<Integer> list = new ArrayList<>();
                for (int i = start; i <= right; i++) {
                    list.add(nums[i]);
                }
                result = Math.max(result, check(list, limit));
                right++;
            }
            start++;
        }
        return result;
    }

    private int check(List<Integer> list, int limit) {
        list.sort(Integer::compare);
        if (list.get(list.size() - 1) - list.get(0) <= limit) {
            return list.size();
        }
        return 0;
    }


    public static void main(String[] args) {
        LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit s = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
        System.out.println(s.longestSubarray(new int[]{8, 2, 4, 7}, 4));//2
        System.out.println(s.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));//4
        System.out.println(s.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));//3
    }
}
