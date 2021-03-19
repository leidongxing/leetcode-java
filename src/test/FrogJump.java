package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/3/19
 * 青蛙过河
 */
public class FrogJump {
    /**
     * 青蛙过河
     * 青蛙上一步跳跃k个单位 下一步只能跳跃 k-1/k/k+1个单位
     * @param stones 石头的位置
     */
    public boolean canCross(int[] stones) {
        //key:当前所处的石头的位置  value:可以通过jumpSize到达该位置k
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);


        for (int i = 0; i < stones.length; i++) {
            //对于当前所在的这个石头位置 的所有k值
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    //存在这样的石头位置
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }


    //暴力法
    public boolean canCross1(int[] stones) {
        return tryCross(stones, 0, 0);
    }

    private boolean tryCross(int[] stones, int lastIndex, int k) {
        for (int i = lastIndex + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[lastIndex];
            //下一步的距离只能选择 k k-1 k+1
            if (gap >= k - 1 && gap <= k + 1) {
                if (tryCross(stones, i, gap)) {
                    return true;
                }
            }
        }
        return lastIndex == stones.length - 1;
    }

    public static void main(String[] args) {
        FrogJump f = new FrogJump();
        System.out.println(f.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));//true
        System.out.println(f.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));//false
    }
}
