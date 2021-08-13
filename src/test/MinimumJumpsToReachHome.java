package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/3/21
 * 到家的最少跳跃次数
 */
public class MinimumJumpsToReachHome {
    /**
     * 起始位置 0
     *
     * @param forbidden 不能跳到数组中的位置 1<=forbidden.length()<=1000
     * @param a         只能往右跳a个位置  1<=a<=2000
     * @param b         只能往左跳b个位置  1<=b<=2000
     * @param x         最终需要到达的位置 0<=x<=2000
     * @return 到家的最少跳跃次数 无法到达返回-1
     */
    //一定可以0 到 a+b+x找到答案
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        for (int i : forbidden) {
            set.add(i);
        }

        Set<Integer> visit = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        //当前位置 方向(1右-1左) 跳跃次数
        queue.offer(new int[]{0, 1, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == x) {
                return poll[2];
            }
            if (visit.contains(poll[0])) {
                continue;
            }
            visit.add(poll[0]);
            //左跳
            if (poll[1] == 1 && poll[0] - b > 0 && !set.contains(poll[0] - b)) {
                queue.offer(new int[]{poll[0] - b, -1, poll[2] + 1});
            }
            //右跳
            if (!set.contains(poll[0] + a) && poll[0] + a < 6000) {
                queue.offer(new int[]{poll[0] + a, 1, poll[2] + 1});
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        MinimumJumpsToReachHome m = new MinimumJumpsToReachHome();
        System.out.println(m.minimumJumps(new int[]{14, 4, 18, 1, 15}, 3, 15, 9));//3
        System.out.println(m.minimumJumps(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11));//-1
        System.out.println(m.minimumJumps(new int[]{1, 6, 2, 14, 5, 17, 4}, 16, 9, 7));//2
    }
}
