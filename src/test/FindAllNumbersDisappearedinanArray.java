package test;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int[] tmp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]] = tmp[nums[i]] + 1;
        }
        for (int j = 1; j < tmp.length; j++) {
            if (tmp[j] == 0) {
                result.add(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedinanArray fa = new FindAllNumbersDisappearedinanArray();
        List<Integer> result = fa.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(result);
    }
}
