package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    // public List<List<Integer>> threeSum(int[] nums) {
    // List<List<Integer>> list = new LinkedList<List<Integer>>();
    // if (nums.length < 3) {
    // return list;
    // }
    // Arrays.sort(nums);
    // int i = 0, j = nums.length-1;
    // while (i < nums.length) {
    // while (j > 1) {
    // int targetIndex = binarySearch(nums, i + 1, j - 1, 0 - nums[i] -
    // nums[j]);
    // if (targetIndex != -1 && targetIndex != j && targetIndex != i) {
    // List<Integer> every = new LinkedList<Integer>();
    // every.add(nums[i]);
    // every.add(nums[j]);
    // every.add(nums[targetIndex]);
    // list.add(every);
    // }
    // j--;
    // while (j > i && nums[j] == nums[j + 1]) {
    // j--;
    // }
    // }
    // i++;
    // j = nums.length-1;
    // while (i<j && nums[i] == nums[i - 1]) {
    // i++;
    // }
    // }
    // return list;
    //
    // }
    //
    // private int binarySearch(int[] nums, int start, int end, int target) {
    // int low = start;
    // int high = end;
    // int mid = (low + high) / 2;
    // while (low <= high) {
    // if (nums[mid] > target) {
    // high = mid - 1;
    // mid = (low + high) / 2;
    // } else if (nums[mid] < target) {
    // low = mid + 1;
    // mid = (low + high) / 2;
    // } else {
    // return mid;
    // }
    // }
    // return -1;
    // }
    // public List<List<Integer>> threeSum(int[] nums) {
    // List<List<Integer>> list = new LinkedList<List<Integer>>();
    // Arrays.sort(nums);
    // for(int i=0;i<nums.length-2;i++){
    // if(i>0 && nums[i]==nums[i-1]){
    // continue;
    // }
    // int start =i+1;
    // int end = nums.length-1;
    // while(start < end){
    // int target =nums[start]+nums[i]+nums[end];
    // if(target<0){
    // start++;
    // }else if(target>0){
    // end--;
    // }else{
    // List<Integer> every = new ArrayList<Integer>();
    // every.add(nums[start]);
    // every.add(nums[i]);
    // every.add(nums[end]);
    // list.add(every);
    // while(start<end && nums[start]==nums[start+1]){
    // start++;
    // }
    // while(start<end && nums[end] ==nums[end-1]){
    // end--;
    // }
    // start++;
    // end--;
    // }
    // }
    //
    // }
    //
    // return list;
    // }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list1 = new ThreeSum().threeSum(new int[]{0, 0, 0}); // [[-1,-1,2],[-1,0,1]]
        for (List<Integer> list : list1) {
            System.out.print("[");
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println("]");
        }
        // -1,0,1,2,-1,-4
        //
    }
}
