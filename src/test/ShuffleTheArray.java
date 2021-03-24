package test;

/**
 * @author LeiDongxing
 * created on 2021/3/24
 * 重新排列数组
 */
public class ShuffleTheArray {

    public int[] shuffle1(int[] nums, int n) {
        int[] result = new int[nums.length];
        int p1 = 0;
        int p2 = n;
        int i = 0;
        while (p1 < n && p2 < nums.length) {
            result[i] = nums[p1];
            p1++;
            i++;
            result[i] = nums[p2];
            p2++;
            i++;
        }
        return result;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[n + i];
        }
        return result;
    }

}
