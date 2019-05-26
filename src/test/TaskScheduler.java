package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] task2times = new int[26];
        for (char c : tasks)
            task2times[c - 'A']++;
        Arrays.sort(task2times);
        int max_val = task2times[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && task2times[i] > 0; i--) {
            idle_slots -= Math.min(task2times[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    public int leastInterval1(char[] tasks, int n) {
        if (n <= 0) {
            return tasks.length;
        }
        int[] task2times = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            task2times[tasks[i] - 'A']++;
        }
        Arrays.sort(task2times);
        int sum = 0;
        while (task2times[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (task2times[25] == 0) {
                    break;
                }
                if (i < 26 && task2times[25 - i] > 0) {
                    task2times[25 - i]--;
                }
                sum++;
                i++;
            }
            Arrays.sort(task2times);
        }
        return sum;
    }

    public int leastInterval3(char[] tasks, int n) {
        int[] task2times = new int[26];
        for (char c : tasks)
            task2times[c - 'A']++;
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : task2times) {
            if (f > 0)
                queue.add(f);
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                sum++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int l : temp)
                queue.add(l);
        }
        return sum;
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        System.out.println(ts.leastInterval3(new char[]{'A', 'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
