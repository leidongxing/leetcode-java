package test;

/**
 * 丢失的数字
 * @author LeiDongxing
 * created on 2021/11/6
 */
public class MissingNumber {
    //[0, n]中n个数的数组nums ，找出[0, n]这个范围内没有出现在数组中的那个数。
    public int missingNumber(int[] nums) {
        //异或  a = a ^ x ^ x
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= i;
            result ^= nums[i];
        }
        result ^= nums.length;
        return result;
    }
}
