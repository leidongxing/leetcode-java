package test;

/**
 * @author LeiDongxing
 * created on 2021/3/14
 * 爱吃香蕉的珂珂
 */
public class KokoEatingBananas {
    /**
     * @param piles 每堆香蕉
     * @param h     小时
     * @return h小时吃点所有香蕉的最小速度
     */
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 1000000000;
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;
            if (eatFinish(piles, h, mid)) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }

    public boolean eatFinish(int[] piles, int h, int speed) {
        int count = 0;
        for (int pile : piles) {
            count += pile / speed + (pile % speed == 0 ? 0 : 1);
            if (count > h) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        KokoEatingBananas k = new KokoEatingBananas();
        System.out.println(k.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));//4
        System.out.println(k.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));//30
        System.out.println(k.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));//23
        System.out.println(k.minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818));//14
    }
}
