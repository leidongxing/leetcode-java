package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/6/25
 * 打开转盘锁
 */
public class OpenTheLock {
    /**
     * target 不在 deadends 之中
     *
     * @param deadends deadends[i].length == 4
     * @param target   target.length == 4
     * @return 最小旋转次数
     */
    public int openLock(String[] deadends, String target) {
        //起始位置为目标
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        //起始位置被锁
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String nextStatus : getAllNext(status)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    private char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    private char numNext(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    private List<String> getAllNext(String status) {
        List<String> result = new ArrayList<>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = array[i];
            array[i] = numPrev(num);
            result.add(new String(array));
            array[i] = numNext(num);
            result.add(new String(array));
            array[i] = num;
        }
        return result;
    }

}
