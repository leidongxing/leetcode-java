package test;

/**
 * @author LeiDongxing
 * created on 2021/2/15
 * 最大连续1的个数
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int tmp = 0;
        for (int num : nums) {
            if (num == 1) {
                tmp++;
            } else {
                result = Math.max(result, tmp);
                tmp = 0;
            }
        }
        result = Math.max(result, tmp);
        return result;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes m = new MaxConsecutiveOnes();
        System.out.println(m.findMaxConsecutiveOnes(new int[]{1}));//1
        System.out.println(m.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));//3
    }
}
