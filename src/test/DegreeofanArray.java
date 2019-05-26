package test;

import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray {
    public int findShortestSubArray(int[] nums) {
        int maxNumber = nums[0];
        int maxTimes = 1;
        Map<Integer, Integer> nubmer2Times = new HashMap<Integer, Integer>();
        nubmer2Times.put(maxNumber, 1);
        Map<Integer, Integer> nubmer2Start = new HashMap<Integer, Integer>();
        nubmer2Start.put(maxNumber, 0);

        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == maxNumber) {
                nubmer2Times.put(maxNumber, nubmer2Times.get(maxNumber) + 1);
                maxTimes++;
                end = i;
            } else {
                if (nubmer2Times.containsKey(nums[i])) {
                    int nowTimes = nubmer2Times.get(nums[i]) + 1;
                    if (nowTimes > maxTimes) {
                        maxTimes = nowTimes;
                        maxNumber = nums[i];
                        end = i;
                    } else if (nowTimes == maxTimes) {
                        int maxD = end - nubmer2Start.get(maxNumber) + 1;
                        int nowD = i - nubmer2Start.get(nums[i]) + 1;
                        if (nowD < maxD) {
                            maxTimes = nowTimes;
                            maxNumber = nums[i];
                            end = i;
                        }
                    }
                    nubmer2Times.put(nums[i], nowTimes);
                } else {
                    nubmer2Start.put(nums[i], i);
                    nubmer2Times.put(nums[i], 1);
                }
            }
        }

        return end - nubmer2Start.get(maxNumber) + 1;
    }

    public static void main(String[] args) {
        DegreeofanArray df = new DegreeofanArray();
        System.out.println(df.findShortestSubArray(new int[]{2, 1, 1, 2, 1, 3, 3, 3, 1, 3, 1, 3, 2}));
    }
}
