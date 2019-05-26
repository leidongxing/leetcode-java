package test;

public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        char[] sChar = s.toCharArray();
        int left = 0;
        int right = 0;
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] == ' ') {
                right = i - 1;
                for (int j = left; j < left + ((right - left + 1) / 2); j++) {
                    char tmp = sChar[j];
                    sChar[j] = sChar[right - j + left];
                    sChar[right - j + left] = tmp;
                }
                left = i + 1;
            } else if (i == sChar.length - 1) {
                right = i;
                for (int j = left; j < left + ((right - left + 1) / 2); j++) {
                    char tmp = sChar[j];
                    sChar[j] = sChar[right - j + left];
                    sChar[right - j + left] = tmp;
                }
            }
        }
        return new String(sChar);
    }

    public static void main(String[] args) {
        ReverseWordsinaStringIII r = new ReverseWordsinaStringIII();
//		System.out.println(r.reverseWords(new String("abc def ghi")));
        System.out.println(r.reverseWords(new String("Let's take LeetCode contest")));
    }
}
