package test;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 实现 strStr()   在 haystack 字符串中找出 needle 字符串出现的第一个位置
     */
    public int strStr1(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int i = 0, j = 0;
        while (i <= haystack.length() - needle.length()) {
            int k = 0;
            j = i;
            while (haystack.charAt(j) == needle.charAt(k)) {
                j++;
                k++;
                if (k == needle.length()) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementstrStr i = new ImplementstrStr();
        System.out.println(i.strStr("Helloworld!", "world"));
        System.out.println(i.strStr("a", "a"));

    }
}
