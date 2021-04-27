package test;

/**
 * @author LeiDongxing
 * created on 2021/4/26
 * 在D天内送达包裹的能力
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int min = 0;
        for (int weight : weights) {
            sum += weight;
            min = Math.max(min, weight);
        }
        int minShip = min;
        int maxShip = sum;
        while (minShip <= maxShip) {
            int mid = minShip + (maxShip - minShip) / 2;
            if (canShip(weights, D, mid)) {
                maxShip = mid - 1;
            } else {
                minShip = mid + 1;
            }
        }
        return minShip;
    }

    public boolean canShip(int[] weights, int D, int ship) {
        int count = 1;
        int currentSum = 0;
        for (int weight : weights) {
            if (currentSum + weight <= ship) {
                currentSum += weight;
            } else {
                currentSum = weight;
                count++;
            }
            if (count > D) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays c = new CapacityToShipPackagesWithinDDays();
        System.out.println(c.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1));//55
        System.out.println(c.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));//15
        System.out.println(c.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));//6
        System.out.println(c.canShip(new int[]{1, 2, 3, 1, 1}, 2, 2));
        System.out.println(c.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));//3
    }

}
