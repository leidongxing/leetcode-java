package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/1/10
 * 字符频次唯一的最小删除次数
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        Arrays.sort(nums);
        int result = 0;
        int max = nums[25];
        for (int i = 24; i >= 0; i--) {
            if (nums[i] == 0) {
                return result;
            } else {
                if (max > 0) {
                    if (nums[i] <= max - 1) {
                        max = nums[i];
                    } else {
                        result += nums[i] - (max - 1);
                        max--;
                    }
                } else {
                    result += nums[i];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeCharacterFrequenciesUnique m = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
        System.out.println(m.minDeletions("aab"));//0
        System.out.println(m.minDeletions("aaabbbcc"));//2
        System.out.println(m.minDeletions("ceabaacb"));//2
        System.out.println(m.minDeletions("accdcdadddbaadbc"));//1
    }
}
