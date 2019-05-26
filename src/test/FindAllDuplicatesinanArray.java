package test;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int[] temp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] = temp[nums[i]] + 1;
        }
        for (int j = 1; j < temp.length; j++) {
            if (temp[j] == 2) {
                result.add(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicatesinanArray fa = new FindAllDuplicatesinanArray();
        List<Integer> result = fa.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(result);
    }
}
