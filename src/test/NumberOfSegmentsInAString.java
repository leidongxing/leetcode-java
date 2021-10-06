package test;

/**
 * @author LeiDongxing
 * created on 2021/10/7
 * 字符串中的单词数
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                result++;
            }
        }
        return result;
    }
}
