package test;

/**
 * @author LeiDongxing
 * created on 2021/3/28
 * 定长子串中元音的最大数目
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {

        int current = 0;
        int left = 0;
        int right = k - 1;
        for (int i = left; i <= right; i++) {
            if (isVowel(s.charAt(i))) {
                current++;
            }
        }
        int result = current;

        right++;
        while (right < s.length()) {
            if (isVowel(s.charAt(left))) {
                current--;
            }
            if (isVowel(s.charAt(right))) {
                current++;
            }
            result = Math.max(result, current);
            left++;
            right++;
        }
        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubstringOfGivenLength m = new MaximumNumberOfVowelsInASubstringOfGivenLength();
        System.out.println(m.maxVowels("abciiidef", 3));//3 2 3 4
        System.out.println(m.maxVowels("aeiou", 2));//2
        System.out.println(m.maxVowels("leetcode", 3));//2
        System.out.println(m.maxVowels("rhythms", 4));//0
        System.out.println(m.maxVowels("tryhard", 4));//1
    }
}
