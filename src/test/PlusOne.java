package test;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean goAhead = false;
        for (int j = digits.length - 1; j >= 0; j--) {
            if (!goAhead) {
                if (digits[j] + 1 <= 9) {
                    digits[j] = digits[j] + 1;
                    goAhead = false;
                    return digits;
                } else {
                    digits[j] = 0;
                    goAhead = true;
                }
            } else {
                if (digits[j] + 1 <= 9) {
                    digits[j] = digits[j] + 1;
                    goAhead = false;
                    return digits;
                } else {
                    digits[j] = 0;
                }
            }
        }

        if (goAhead == true) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] num = po.plusOne(new int[]{8, 9, 9});
        System.out.println(num);
    }
}
