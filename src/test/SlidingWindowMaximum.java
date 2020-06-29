package test;

import java.util.*;

/**
 * 滑动窗口最大值
 *
 * @author LeiDongxing
 * create on 2020/6/28 7:22
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
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
