package test;

/**
 * @author LeiDongxing
 * created on 2021/5/9
 * 制作m束花所需的最少天数
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    /**
     * @param bloomDay 每朵花的等待天数
     * @param m        需要制作m束花
     * @param k        每束花需要使用相邻k朵花
     * @return 返回需要的最少等待天数
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            min = Math.min(bloomDay[i], min);
            max = Math.max(bloomDay[i], max);
        }
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canFinish(bloomDay, m, k, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean canFinish(int[] bloomDay, int m, int k, int days) {
        int sum = 0;
        int mCount = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] - days <= 0) {
                mCount++;
                if (mCount == k) {
                    sum++;
                    mCount = 0;
                }
            } else {
                mCount = 0;
            }
        }
        return sum >= m;
    }

    public static void main(String[] args) {
        MinimumNumberOfDaysToMakeMBouquets m = new MinimumNumberOfDaysToMakeMBouquets();
//        System.out.println(m.canFinish(new int[]{1, 10, 3, 10, 2}, 3, 1, 2));//3
//        System.out.println(m.canFinish(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3, 7));//12
//        System.out.println(m.canFinish(new int[]{1000000000, 1000000000}, 1, 1, 1000000000));//
//        System.out.println(m.canFinish(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2, 9));
      //  System.out.println(m.canFinish(new int[]{62, 75, 98, 63, 47, 65, 51, 87, 22, 27, 73, 92, 76, 44, 13, 90, 100, 85}, 2, 7, 97));
        System.out.println(m.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));//3
        System.out.println(m.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));//-1
        System.out.println(m.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));//12
        System.out.println(m.minDays(new int[]{1000000000, 1000000000}, 1, 1));//1000000000
        System.out.println(m.minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));//9
        System.out.println(m.minDays(new int[]{62, 75, 98, 63, 47, 65, 51, 87, 22, 27, 73, 92, 76, 44, 13, 90, 100, 85}, 2, 7));//98
    }
}
