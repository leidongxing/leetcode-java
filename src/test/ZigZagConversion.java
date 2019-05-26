package test;

public class ZigZagConversion implements Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] sbArr = new StringBuilder[numRows];
        int height = 0;
        boolean all = true;
        for (int i = 0; i < numRows; i++) {
            sbArr[i] = new StringBuilder();
        }

        if (numRows == 2) {
            for (int i = 0, j = 0; i < s.length(); i++) {
                if (all) {
                    sbArr[j].append(s.charAt(i));
                    height++;
                    j++;
                    if (height >= numRows) {
                        height = 0;
                        all = false;
                        j = 0;
                    }
                } else {
                    sbArr[j].append(s.charAt(i));
                    j++;
                    if (j >= 2) {
                        all = true;
                        j = 0;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                sb.append(sbArr[i]);
            }
            return sb.toString();
        }

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (all) {
                sbArr[j].append(s.charAt(i));
                height++;
                j++;
                if (height >= numRows) {
                    height = 0;
                    all = false;
                    j = numRows - 2;
                }
            } else {
                sbArr[j].append(s.charAt(i));
                j--;
                if (j <= 0) {
                    all = true;
                    j = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(sbArr[i]);
        }
        return sb.toString();
    }

    @Override
    public void doIt() {
        System.out.println(this.convert("AB", 2)); // AB
        System.out.println(this.convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(this.convert("ABC", 2)); // ACB
        System.out.println(this.convert("ABC", 3));// ABC
        System.out.println(this.convert("ABCD", 2));// ACBD
        System.out.println(this.convert("ABCDE", 4));// ABCED
        System.out.println(this.convert("ABCDEF", 4));// ABFCED
    }

    public static void main(String[] args) {
        ZigZagConversion z = new ZigZagConversion();
        new ClacTimeThread(z).run();
    }
}
