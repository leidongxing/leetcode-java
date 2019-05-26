package algorithm;

public class KMP {
    private char[] tChar = "abcsddakkfqqoodfadashweyuqiryqiwoybcbcnxncuvlq".toCharArray();

    public int bruteForce1(char[] pChar) {
        int t = 0, p = 0;
        while (t < tChar.length && p < pChar.length) {
            if (tChar[t] == pChar[p]) {
                t++;
                p++;
            } else {
                t = t - p + 1;
                p = 0;
            }
        }

        return t - p;
    }

    public int bruteForce2(char[] pChar) {
        int t, p;
        for (t = 0; t < tChar.length - pChar.length + 1; t++) {
            for (p = 0; p < pChar.length; p++) {
                if (tChar[t + p] != pChar[p]) {
                    break;
                }
            }
            if (p >= pChar.length) {
                break;
            }
        }
        return t;

    }

    public int match(char[] pChar) {
        int[] next = bulidNext(pChar);
        int t = 0, p = 0;
        while (t < tChar.length && p < pChar.length) {
            if (tChar[t] == pChar[p]) {
                t++;
                p++;
            } else {
                p = next[p];
            }
        }
        return t - p;
    }

    public int[] bulidNext(char[] pChar) {
        int m = pChar.length;
        int j = 0;
        int[] next = new int[m];
        int t = next[0] = -1;
        while (j < m - 1) {
            if (0 > t || pChar[j] == pChar[t]) {
                j++;
                t++;
                pChar[j] = 7;
            } else {
                t = pChar[t];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.bruteForce1("dak".toCharArray()));
        System.out.println(kmp.bruteForce2("dak".toCharArray()));
    }


}
