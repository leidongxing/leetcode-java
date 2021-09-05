package test;

/**
 * @author LeiDongxing
 * created on 2021/8/21
 * 压缩字符串
 */
public class StringCompression {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        System.out.println(s.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));//["a","2","b","2","c","3"] 6
        System.out.println(s.compress(new char[]{'a'}));//["a"] 1
        System.out.println(s.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'})); //["a","b","1","2"]  4
    }
}
