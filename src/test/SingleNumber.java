package test;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    //	 public int singleNumber(int[] nums) {
//		 Set<Integer> hs = new HashSet<Integer>();
//	     for(int i=0;i<nums.length;i++) {
//	    	 if(hs.contains(nums[i])) {
//	    		 hs.remove(nums[i]);
//	    	 }else {
//	    		 hs.add(nums[i]);
//	    	 }
//	     }
//	     return hs.iterator().next();
//	 }
    //0^N=N N^N=0  //^异或 xor  ~取非  &与
    public int singleNumber(int[] nums) {
        int ans = 0;

        int len = nums.length;
        for (int i = 0; i != len; i++)
            ans ^= nums[i];

        return ans;

    }

    public static void main(String[] args) {
        SingleNumber r = new SingleNumber();
        r.singleNumber(new int[]{2, 2, 1});
    }
}
