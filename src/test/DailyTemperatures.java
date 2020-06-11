package test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author LeiDongxing
 * create on 2020/6/11 21:30
 * 739 每日温度
 */
public class DailyTemperatures {
    //单调栈 从栈顶到栈底 元素递增
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        //存的是数组下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }


    //暴力破解
    public int[] dailyTemperatures1(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            boolean hasFind = false;
            for (int j = i + 1; j < T.length; j++) {
                if (T[i] < T[j]) {
                    result[i] = j - i;
                    hasFind = true;
                    break;
                }
            }
            if (!hasFind) {
                result[i] = 0;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))); //[1, 1, 4, 2, 1, 1, 0, 0]
    }
}
