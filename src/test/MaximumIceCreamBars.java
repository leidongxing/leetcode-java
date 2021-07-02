package test;

import java.util.Arrays;

/**
 * 雪糕的最大数量
 */
public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] <= coins) {
                result++;
                coins -= costs[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumIceCreamBars m = new MaximumIceCreamBars();
        System.out.println(m.maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(m.maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(m.maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
    }

}
