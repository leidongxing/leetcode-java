package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElementII {
    //Moore majority vote algorithm
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return resultList;
        }
        int candidateA = nums[0];
        int candidateB = nums[0];
        int countA = 0;
        int countB = 0;

        for (int num : nums) {
            if (num == candidateA) {
                countA++;
                continue;
            }
            if (num == candidateB) {
                countB++;
                continue;
            }
            if (countA == 0) {
                candidateA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                candidateB = num;
                countB++;
                continue;
            }
            countA--;
            countB--;
        }
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == candidateA) {
                countA++;
            } else if (num == candidateB) {
                countB++;
            }
        }

        if (countA > nums.length / 3) {
            resultList.add(candidateA);
        }
        if (countB > nums.length / 3) {
            resultList.add(candidateB);
        }
        return resultList;
    }


    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> num2times = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (num2times.containsKey(nums[i])) {
                num2times.put(nums[i], num2times.get(nums[i]) + 1);
            } else {
                num2times.put(nums[i], 1);
            }
        }
        for (Entry<Integer, Integer> entry : num2times.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                result.add(entry.getKey());
            }
            if (result.size() == 2) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MajorityElementII me = new MajorityElementII();
//		System.out.println(me.majorityElement(new int[] { 3, 2 ,3 }));
        System.out.println(me.majorityElement(new int[]{1, 2, 3, 4, 5, 5, 6, 6, 6, 6, 3, 3, 3, 3, 3, 3, 3}));
    }
}
