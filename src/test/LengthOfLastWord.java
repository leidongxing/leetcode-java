package test;

/**
 * @author LeiDongxing
 * created on 2021/2/28
 * 最后一个单词的长度
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int right = s.length() - 1;
        //从后到前 消除空格
        while (right > 0 && s.charAt(right) == ' ') {
            right--;
        }
        if (right < 0) {
            return 0;
        }
        int left = right;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        return right - left;
    }
}
