package test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LeiDongxing
 * created on 2021/11/1
 * 分糖果
 */
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        int maxCanEat = candyType.length / 2;
        Set<Integer> hashSet = new HashSet<>();
        for (int candy : candyType) {
            hashSet.add(candy);
        }
        return Math.min(maxCanEat, hashSet.size());
    }
}
