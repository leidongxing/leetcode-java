package test;

import java.util.*;

/**
 * 数组中的第K个最大元素
 *
 * @author LeiDongxing
 * create on 2020/6/29 7:42
 */
public class KthLargestElementinanArray {
    //堆排序
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //排序
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest1(int[] nums, int k) {
        //栈顶保存第K大的元素
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        KthLargestElementinanArray k = new KthLargestElementinanArray();
        System.out.println(k.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
        System.out.println(k.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));//4
    }
}
