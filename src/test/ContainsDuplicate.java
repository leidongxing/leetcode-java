package test;

import java.util.HashSet;

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
}
