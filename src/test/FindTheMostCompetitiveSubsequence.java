package test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author LeiDongxing
 * created on 2021/3/6
 * 找出最具竞争力的子序列
 */
public class FindTheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < nums.length; i++) {
            //当前元素比栈顶元素小
            while (nums[i] < stack.peek() && nums.length - i > k - stack.size() + 1) {
                //栈顶元素出栈
                stack.pop();
            }
            if (stack.size() < k + 1) {
                stack.add(nums[i]);
            }
        }
        int[] result = new int[k];
        while (k > 0) {
            k--;
            result[k] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        FindTheMostCompetitiveSubsequence f = new FindTheMostCompetitiveSubsequence();
        System.out.println(Arrays.toString(f.mostCompetitive(new int[]{3, 5, 2, 6}, 2)));//2 6
        System.out.println(Arrays.toString(f.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4))); //2 3 4 5
    }
}
