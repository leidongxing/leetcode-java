package test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int secondKey = map.get(target - nums[i]);
                if (secondKey > i) {
                    solution[0] = i;
                    solution[1] = secondKey;
                } else {
                    solution[0] = secondKey;
                    solution[1] = i;
                }
                return solution;
            }
            map.put(nums[i], i);
        }
        return solution;

    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] solution = new TwoSum().twoSum(nums, 6);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }
}
