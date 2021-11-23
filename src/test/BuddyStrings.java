package test;

/**
 * @author LeiDongxing
 * created on 2021/11/23
 * 亲密字符串
 */
public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int[] sMap = new int[26];
        int[] gMap = new int[26];
        int needSwap = 0;

        for (int i = 0; i < s.length(); i++) {
            sMap[s.charAt(i) - 'a']++;
            gMap[goal.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i)) {
                needSwap++;
            }
            if (needSwap > 2) {
                return false;
            }
        }
        if (needSwap != 2 && needSwap != 0) {
            return false;
        }

        boolean isMoreOne = false;
        for (int i = 0; i < 26; i++) {
            if (sMap[i] != gMap[i]) {
                return false;
            }
            if (sMap[i] > 1) {
                isMoreOne = true;
            }
        }
        if (needSwap == 0) {
            return isMoreOne;
        }
        return true;
    }

    public static void main(String[] args) {
        BuddyStrings bs = new BuddyStrings();
        System.out.println(bs.buddyStrings("ab", "ba"));//true
        System.out.println(bs.buddyStrings("ab", "ab"));//false
        System.out.println(bs.buddyStrings("aa", "aa"));//true
        System.out.println(bs.buddyStrings("aaaaaaabc", "aaaaaaacb"));//true  abcd    abcd
        System.out.println(bs.buddyStrings("abcd", "badc"));//false
    }
}
