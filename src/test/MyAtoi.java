package test;

public class MyAtoi implements Solution {
    // alphanumeric to integer
    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();
        boolean isSigin = false;
        boolean isNegative = false;
        long solution = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sb.append(str.charAt(i));
            } else if (str.charAt(i) == ' ') {
                if (isSigin || sb.length() != 0) {
                    break;
                }
            } else if (str.charAt(i) == '+') {
                if (isSigin || sb.length() != 0) {
                    break;
                }
                isSigin = true;
            } else if (str.charAt(i) == '-') {
                if (isSigin || sb.length() != 0) {
                    break;
                }
                isSigin = true;
                isNegative = true;
            } else {
                break;
            }


            if (sb.length() != 0) {
                if (isNegative) {
                    solution = Long.valueOf("-" + sb.toString());
                    if (solution < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    solution = Long.valueOf(sb.toString());
                    if (solution > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            }

        }
        return (int) solution;

    }

    @Override
    public void doIt() {
        System.out.println(this.myAtoi(""));// 0
        System.out.println(this.myAtoi("+"));// 0
        System.out.println(this.myAtoi("-"));// 0
        System.out.println(this.myAtoi("+1"));// 1
        System.out.println(this.myAtoi("123.12"));// 123
        System.out.println(this.myAtoi("2147483648"));// 2147483647
        System.out.println(this.myAtoi("9223372036854775809"));// 2147483647
        System.out.println(this.myAtoi("b11228552307"));// 0
        System.out.println(this.myAtoi("    010"));// 10
        System.out.println(this.myAtoi("   +0 123"));// 0
        System.out.println(this.myAtoi("     +004500")); // 4500
        System.out.println(this.myAtoi("+-2")); // 0
        System.out.println(this.myAtoi("1"));// 1
        System.out.println(this.myAtoi("    -00134"));// -134
        System.out.println(this.myAtoi("   +0 123")); //0
        System.out.println(this.myAtoi("   - 321")); //0
    }

    public static void main(String[] args) {
        MyAtoi m = new MyAtoi();
        new ClacTimeThread(m).run();
        //
        // String s = "";
//		 System.out.println(Integer.valueOf("-5"));
        // System.out.println("".length());
    }
}
