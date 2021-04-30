package test;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 */
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
        for (int i = 0; i != len; i++) {
            ans ^= nums[i];
        }

        return ans;
    }

    /**
     * 只出现一次的数字 II
     * 某个元素仅出现 一次 外，其余每个元素都恰出现 三次
     */
    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }

    public static void main(String[] args) {
        SingleNumber r = new SingleNumber();
        r.singleNumber(new int[]{2, 2, 1});
        System.out.println(1 ^ 2);
    }
}
