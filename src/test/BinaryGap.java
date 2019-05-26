package test;

public class BinaryGap {
    public int binaryGap(int N) {
        int last = -1;
        int index = 0;
        int max = 0;
        while (N >= 1) {
            index++;
            if (N % 2 == 1) {
                if (last == -1) {
                    last = index;
                } else {
                    if (index - last > max) {
                        max = index - last;
                    }
                    last = index;
                }
            }
            N = N / 2;
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        BinaryGap b = new BinaryGap();
        b.binaryGap(8);
    }
}
