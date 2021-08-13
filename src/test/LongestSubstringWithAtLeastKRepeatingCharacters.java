package test;

/**
 * @author LeiDongxing
 * created on 2021/2/27
 * 至少有K个重复字符的最长子串
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int result = 0;
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] count = new int[26];
            //滑动窗口内的字符种类总数
            int total = 0;
            //标记出现次数小于k的字符数量
            int less = 0;
            while (r < s.length()) {
                count[s.charAt(r) - 'a']++;
                if (count[s.charAt(r) - 'a'] == 1) {
                    //刚刚出现
                    total++;
                    less++;
                }
                if (count[s.charAt(r) - 'a'] == k) {
                    //已经到达k
                    less--;
                }

                while (total > t) {
                    count[s.charAt(l) - 'a']--;
                    if (count[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    if (count[s.charAt(l) - 'a'] == 0) {
                        total--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    result = Math.max(result, r - l + 1);
                }
                r++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingCharacters l = new LongestSubstringWithAtLeastKRepeatingCharacters();
        System.out.println(l.longestSubstring("a", 1));//3 aaa
        System.out.println(l.longestSubstring("aaabb", 3));//3 aaa
        System.out.println(l.longestSubstring("ababbc", 2));//5  ababb
    }
}
