package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(result,new ArrayList<>(),nums,0);
        for (int i = 0; i < nums.length; i++) {

        }
        return result;
    }

    private void backtrack(List<List<Integer>> list,List<Integer> tempList,int[] nums,int start){
        list.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        SubSets s = new SubSets();
        List<List<Integer>> result = s.subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }
}
