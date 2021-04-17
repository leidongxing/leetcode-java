package test;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author LeiDongxing
 * created on 2020/12/13
 * 存在重复元素
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * 存在重复元素 III
     * 存在 abs(nums[i] - nums[j]) <= t && abs(i - j) <= k
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // nums[i]-t<=nums[j]
        //维护大小为k的滑动窗口  遍历到元素x时  检查是否有元素落在[x-t,x+t]区间
        //存储数组值
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long c = set.ceiling((long) nums[i] - (long) t);
            //不能超出nums[i]+t
            if (c != null && c <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            //移动滑动窗口
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }


    //暴力法超时
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (Math.abs(j - i) <= k && Math.abs((long) nums[j] - (long) nums[i]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
