package test;

/**
 * @author LeiDongxing
 * created on 2020/12/29
 * 按要求补齐数组  从1补到n
 */
public class PatchingArray {
    //对于正整数 x，如果区间 [1,x-1] 内的所有数字都已经被覆盖，且 x 在数组中，则区间 [1,2x-1]内的所有数字也都被覆盖
    public int minPatches(int[] nums, int n) {
        int result = 0;
        //x从最小的1开始
        long x = 1;
        int index = 0;
        //每次找到未被数组覆盖的最小整数x  补充x
        //x大于n的数字不考虑
        while (x <= n) {
            if (index < nums.length && nums[index] <= x) {
                //x 不会小于x+ nums[index]
                x += nums[index];
                index++;
            } else {
                //补充x后 [1,2x-1]都会被覆盖 缺失数字一定不小于2x
                x *= 2;
                result++;
            }
        }
        return result;
    }
}
