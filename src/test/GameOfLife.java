package test;

/**
 * @author LeiDongxing
 * created on 2021/2/21
 * 生命游戏
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {

    }


    public int breakNum(int[] nums) {
        //从后向前遍历  尽可能均匀的切  既要满足前面的 又要满足后面的
        int preMax = nums[nums.length - 1];
        int result = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > preMax) {
                //最大需要次数 12切成6 只需要1刀
                int cut = (nums[i] - 1) / preMax;
                preMax = nums[i] / (cut + 1);
                result += cut;
            } else {
                preMax = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GameOfLife().breakNum(new int[]{2, 13, 6}));//1
        System.out.println(new GameOfLife().breakNum(new int[]{3, 5, 13, 9, 12}));//1
        System.out.println(new GameOfLife().breakNum(new int[]{3, 12, 13, 9, 12}));//2
        System.out.println(new GameOfLife().breakNum(new int[]{3, 13, 12, 9, 12}));//3
        System.out.println(new GameOfLife().breakNum(new int[]{3, 13, 60, 7}));//10
        System.out.println(new GameOfLife().breakNum(new int[]{3, 63, 7}));//8
        System.out.println(new GameOfLife().breakNum(new int[]{9, 1}));//8
    }
}
