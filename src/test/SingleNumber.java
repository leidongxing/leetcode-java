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

    /**
     * 只出现一次的数字 III
     * 恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
     */
    public int[] singleNumber3(int[] nums) {
        int xorsum = 0;
        //所有出现一次的元素异或和
        for (int num : nums) {
            xorsum ^= num;
        }
        //防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }

    public static void main(String[] args) {
        SingleNumber r = new SingleNumber();
        r.singleNumber(new int[]{2, 2, 1});
        System.out.println(1 ^ 2);
    }
}
