package test;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        /**
         * int[] count = new int[128];
         for (char c: s.toCharArray())
         count[c]++;
         */
        int sum = 0;
        boolean isCenter = false;
        Map<Character, Integer> char2Num = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (char2Num.containsKey(s.charAt(i))) {
                char2Num.put(s.charAt(i), char2Num.get(s.charAt(i)) + 1);
            } else {
                char2Num.put(s.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : char2Num.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                sum += entry.getValue();
            } else {
                isCenter = true;
                sum += entry.getValue() - 1;

            }
        }
        return isCenter ? sum + 1 : sum;
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        String n = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(l.longestPalindrome(n));
    }
}
