package test;

public class AddDigits {
    public int addDigits(int num) {
        int sum = 0;
        while (true) {
            while (num >= 10) {
                sum += num % 10;
                num = num / 10;
            }
            sum += num;
            if (sum < 10) {
                break;
            } else {
                num = sum;
                sum = 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
//		System.out.println(ad.addDigits(38));
        System.out.println(ad.addDigits(10));
    }
}
