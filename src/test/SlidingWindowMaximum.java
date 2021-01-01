package test;

import java.util.*;

/**
 * 滑动窗口最大值
 * @author LeiDongxing
 * create on 2020/6/28 7:22
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //最大值相同 坐标排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        //存储最开始的最大元素和坐标
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] result = new int[n - k + 1];
        //第一个滑动窗口最大值
        result[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            result[i - k + 1] = pq.peek()[0];
        }
        return result;
    }


    /**
     * 双向队列
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        //双端队列 保存的是数组的坐标
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //存在比它老的 还比他小的 直接出队
            while ((!queue.isEmpty() && nums[queue.peekLast()] < nums[i])) {
                queue.pollLast();
            }
            //当前窗口已经大于k  前端直接出队
            if (!queue.isEmpty() && i - queue.getFirst() + 1 > k) {
                queue.pollFirst();
            }

            //入队
            queue.add(i);
            int maxIndex = queue.peekFirst();
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[maxIndex];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum r = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(r.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
