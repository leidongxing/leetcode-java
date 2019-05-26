package test;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int sum = 0;
        while (x > 0 && y > 0) {
            if (x % 2 != y % 2) {
                sum++;
            }
            x = x / 2;
            y = y / 2;
        }

        while (x > 0) {
            if (x % 2 != 0) {
                sum++;
            }
            x = x / 2;
        }

        while (y > 0) {
            if (y % 2 != 0) {
                sum++;
            }
            y = y / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        HammingDistance h = new HammingDistance();
        System.out.println(h.hammingDistance(1, 14));

    }
}
