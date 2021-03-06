package test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author LeiDongxing
 * created on 2021/3/6
 * 下一个更大元素 II
 */
public class NextGreaterElementII {
    // 遍历数组，如果元素是单调递减的（则他们的「下一个更大元素」相同），这些元素保存，直到找到一个较大的元素；
    // 把该较大元素逐一跟保存了的元素比较，如果该元素更大，它就是前面元素的「下一个更大元素」。
    // 构造单调递增栈  当前元素大于栈顶元素 即为它的下一个更大元素
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        //用-1填充
        Arrays.fill(result, -1);

        //保存元素的位置
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                //当前元素大于栈顶元素
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    result[stack.peek()] = nums[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                //当前元素大于栈顶元素
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    result[stack.peek()] = nums[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return result;
    }


    //单调栈 循环数组
    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        //用-1填充
        Arrays.fill(result, -1);

        //保存元素的位置
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(new int[]{1, 2, 1})));
    }
}
