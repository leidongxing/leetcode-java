package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/3/6
 * 下一个更大元素I
 */
public class NextGreaterElementI {
    /**
     * nums1是nums2的子集 均无重复元素
     * 找出nums[1]中每个元素在nums[2]中对应位置的右边的下一个更大值
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //单调递减栈 栈顶索引元素最大
        Stack<Integer> stack = new Stack<>();
        //记录每一个nums2的更大值
        Map<Integer, Integer> element2Greater = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            //当前元素比栈顶索引元素还大
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int index = stack.pop();
                //当前栈顶元素的下一个最大元素就是当前元素
                element2Greater.put(nums2[index], nums2[i]);
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int index = stack.pop();
            //大元素的下一个最大值为-1
            element2Greater.put(nums2[index], -1);
        }


        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = element2Greater.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(new int[]{4, 1, 2, 222}, new int[]{1, 3, 4, 2, 10, 11, 222, 1234})));//-1 3 -1
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));//-1 3 -1
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}))); //3 -1
    }
}
