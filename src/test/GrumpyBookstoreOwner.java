package test;

/**
 * @author LeiDongxing
 * created on 2021/2/23
 * 爱生气的书店老板
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //不使用秘密技巧 所有满意的客人总数
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        //使用秘密技巧 提升满意度的客人总数
        int increase = 0;
        for (int i = 0; i < X; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = X; i < customers.length; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return sum + maxIncrease;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner g = new GrumpyBookstoreOwner();
        System.out.println(g.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));//16
    }
}
