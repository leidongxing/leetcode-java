package test;

/**
 * 最小操作次数使数组元素相等
 */
public class MinimumMovesToEqualArrayElements {
    /**
     * 长度为n的整数数组，每次操作将会使n-1个元素增加1
     * 返回让数组所有元素相等的最小操作次数。
     */
    public int minMoves(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        //找出最小的
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int res = 0;
        for (int n : nums) {
            res += n - min;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElements m = new MinimumMovesToEqualArrayElements();
        System.out.println(m.minMoves(new int[]{1, 2, 3}));//3
        System.out.println(m.minMoves(new int[]{1, 1, 1}));//0
    }
}
