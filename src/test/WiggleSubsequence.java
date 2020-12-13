package test;

/**
 * @author LeiDongxing
 * created on 2020/12/12
 * 摆动序列
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        //少于两个元素的序列也是摆动序列
        if (nums.length < 2) {
            return nums.length;
        }
        //最后一个元素呈上升趋势  原始 上升 下降 上升
        int[] up = new int[nums.length];
        //最后一个元素呈下降趋势  原始 下降 上升 下降
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            //上升趋势
            if (nums[i] > nums[i - 1]) {
                //前一个下降序列 转换为上升序列
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }

    public int wiggleMaxLength1(int[] nums) {
        //少于两个元素的序列也是摆动序列
        if (nums.length < 2) {
            return nums.length;
        }
        //当前的上升序列 最后一个元素呈上升趋势  原始 上升 下降 上升
        int up = 1;
        //当前的下降序列 最后一个元素呈下降趋势  原始 下降 上升 下降
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            //上升趋势
            if (nums[i] > nums[i - 1]) {
                //前一个下降序列 转换为上升序列
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(down, up + 1);
            }
        }
        return Math.max(up, down);
    }


    public static void main(String[] args) {
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));//6
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));//7
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));//2

    }
}
