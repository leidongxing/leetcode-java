package test;

/**
 * @author LeiDongxing
 * created on 2021/3/13
 * 寻找峰值
 */
public class FindPeakElement {
    /**
     * 峰值元素是指其值大于左右相邻值的元素
     * 数组可能包含多个峰值，返回 任何一个峰值所在位置即可
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && i + 1 < nums.length) {
                if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                    return i;
                }
            } else if (i - 1 >= 0) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement(new int[]{1}));
        System.out.println(f.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(f.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}