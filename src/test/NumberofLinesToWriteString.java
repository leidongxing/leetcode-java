package test;

public class NumberofLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int[] result = new int[2];
        char[] sChar = S.toCharArray();
        int sum = 0;
        int lines = 1;
        for (int i = 0; i < sChar.length; i++) {
            int width = widths[(sChar[i] - 'a')];
            if (sum + width > 100) {
                sum = width;
                lines++;
            } else {
                sum += width;
            }
        }
        result[0] = lines;
        result[1] = sum;
        return result;
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');
    }
}
