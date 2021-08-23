package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/8/23
 * 获取生成数组中的最大值
 */
public class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int[] nums = new int[n + 1];
            nums[0] = 0;
            nums[1] = 1;
            int max = 1;
            int i = 1;
            while (i <= n) {
                if (2 <= 2 * i && 2 * i <= n) {
                    nums[2 * i] = nums[i];
                    max = Math.max(max, nums[2 * i]);
                }
                if (2 <= 2 * i + 1 && 2 * i + 1 <= n) {
                    nums[2 * i + 1] = nums[i] + nums[i + 1];
                    max = Math.max(max, nums[2 * i + 1]);
                }
                i++;
            }

            System.out.println(Arrays.toString(nums));
            return max;
        }
    }

    public static void main(String[] args) {
        GetMaximumInGeneratedArray g = new GetMaximumInGeneratedArray();
        System.out.println(g.getMaximumGenerated(0));
    }
}
