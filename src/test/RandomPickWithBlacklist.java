package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2022/6/26
 * 黑名单中的随机数
 */
public class RandomPickWithBlacklist {

    private Map<Integer, Integer> b2w;
    private Random random;
    private int bound;

    /**
     * 黑名单映射
     */
    public RandomPickWithBlacklist(int n, int[] blacklist) {
        b2w = new HashMap<>();
        random = new Random();
        int m = blacklist.length;
        bound = n - m;
        Set<Integer> black = new HashSet<>();
        for (int b : blacklist) {
            if (b >= bound) {
                black.add(b);
            }
        }
        int w = bound;
        for (int b : blacklist) {
            if (b < bound) {
                while (black.contains(w)) {
                    w++;
                }
                b2w.put(b, w);
                w++;
            }
        }
        System.out.println(b2w);
    }

    public int pick() {
        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }


    public static void main(String[] args) {
        //将 0-7中黑名单2、3、5    生成 0,1,2,3 映射成 0,1,4,6
        RandomPickWithBlacklist r = new RandomPickWithBlacklist(7, new int[]{2, 3, 5});
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int n = r.pick();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
    }
}
