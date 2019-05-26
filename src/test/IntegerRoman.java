package test;

public class IntegerRoman {

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "-1";
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(numerals[i]);
            }
        }
        return result.toString();
    }

    public int romanToInt(String s) {
        int sum = 0;
        if (s.indexOf("IV") != -1) {
            sum -= 2;
        }
        if (s.indexOf("IX") != -1) {
            sum -= 2;
        }
        if (s.indexOf("XL") != -1) {
            sum -= 20;
        }
        if (s.indexOf("XC") != -1) {
            sum -= 20;
        }
        if (s.indexOf("CD") != -1) {
            sum -= 200;
        }
        if (s.indexOf("CM") != -1) {
            sum -= 200;
        }

        char c[] = s.toCharArray();
        int count = 0;

        for (; count <= s.length() - 1; count++) {
            if (c[count] == 'M')
                sum += 1000;
            if (c[count] == 'D')
                sum += 500;
            if (c[count] == 'C')
                sum += 100;
            if (c[count] == 'L')
                sum += 50;
            if (c[count] == 'X')
                sum += 10;
            if (c[count] == 'V')
                sum += 5;
            if (c[count] == 'I')
                sum += 1;

        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerRoman().intToRoman(3999));
    }
}