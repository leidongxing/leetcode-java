package test;

/**
 * @author LeiDongxing
 * created on 2021/3/28
 * 队列的最大值
 */
public class MaxQueue {
    private final int[] queue;
    private int begin;
    private int end;

    public MaxQueue() {
        queue = new int[20000];
        begin = 0;
        end = 0;
    }

    public int max_value() {
        int max = -1;
        for (int i = begin; i != end; i++) {
            max = Math.max(max, queue[i]);
        }
        return max;
    }

    public void push_back(int value) {
        queue[end] = value;
        end++;
    }

    public int pop_front() {
        if (begin == end) {
            return -1;
        }
        begin++;
        return queue[begin - 1];
    }

    public static void main(String[] args) {
        MaxQueue q = new MaxQueue();
        q.push_back(1);
        q.push_back(2);
        System.out.println(q.max_value());
        System.out.println(q.pop_front());
        System.out.println(q.max_value());
    }
}
