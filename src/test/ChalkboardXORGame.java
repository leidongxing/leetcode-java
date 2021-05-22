package test;

/**
 * @author LeiDongxing
 * created on 2021/5/22
 * 黑板异或游戏
 */
public class ChalkboardXORGame {
    //Alice必胜
    //数组 nums 的全部元素的异或结果等于0
    //数组 nums 的长度是偶数。
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
}
