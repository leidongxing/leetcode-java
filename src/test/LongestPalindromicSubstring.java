package test;

public class LongestPalindromicSubstring implements Solution {
    private int start, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(start, start + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {  //		(k-1) - (j+1) +1
            start = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring los = new LongestPalindromicSubstring();
        new ClacTimeThread(los).start();
    }

    @Override
    public void doIt() {
//		this.longestPalindrome("babad");// bab aba
//		this.longestPalindrome("cbbd"); // bb
//		this.longestPalindrome("bananas"); // anana
//		this.longestPalindrome("bb"); // bb
//		this.longestPalindrome("aba"); // aba
    }
}
