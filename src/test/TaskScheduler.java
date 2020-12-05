package test;

import java.util.*;

/**
 * 任务调度器
 */
public class TaskScheduler {
    public int leastInterval4(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        // 最多的执行次数
        int maxTimes = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxTimes = Math.max(maxTimes, exec);
        }

        // 具有最多执行次数的任务数量
        int taskCount = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int value = entry.getValue();
            if (value == maxTimes) {
                taskCount++;
            }
        }

        return Math.max((maxTimes - 1) * (n + 1) + taskCount, tasks.length);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] task2times = new int[26];
        for (char c : tasks) {
            task2times[c - 'A']++;
        }
        Arrays.sort(task2times);
        // A * * A * * A * * A    4-1  (4-1)*2
        int maxVal = task2times[25] - 1, maxSpace = maxVal * n;
        for (int i = 24; i >= 0 && task2times[i] > 0; i--) {
            maxSpace -= Math.min(task2times[i], maxVal);
        }
        return maxSpace > 0 ? maxSpace + tasks.length : tasks.length;
    }

    public int leastInterval1(char[] tasks, int n) {
        if (n <= 0) {
            return tasks.length;
        }
        int[] task2times = new int[26];
        for (char task : tasks) {
            task2times[task - 'A']++;
        }
        Arrays.sort(task2times);
        int result = 0;
        while (task2times[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (task2times[25] == 0) {
                    break;
                }
                if (i < 26 && task2times[25 - i] > 0) {
                    task2times[25 - i]--;
                }
                result++;
                i++;
            }
            Arrays.sort(task2times);
        }
        return result;
    }

    public int leastInterval3(char[] tasks, int n) {
        int[] task2times = new int[26];
        for (char c : tasks) {
            task2times[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : task2times) {
            if (f > 0) {
                queue.add(f);
            }
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                sum++;
                if (queue.isEmpty() && temp.size() == 0) {
                    break;
                }
                i++;
            }
            for (int l : temp) {
                queue.add(l);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        System.out.println(ts.leastInterval(new char[]{'A', 'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
