package test;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
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
