package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author LeiDongxing
 * created on 2021/3/17
 * 打乱数组
 */
public class ShuffleAnArray {

    class Solution {
        private int[] array;
        private int[] original;
        private Random rand = new Random();

        private List<Integer> getArrayCopy() {
            List<Integer> asList = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                asList.add(array[i]);
            }
            return asList;
        }

        /**
         * 使用整数数组 nums 初始化对象
         */
        public Solution(int[] nums) {
            array = nums;
            original = nums.clone();
        }

        /**
         * 重设数组到它的初始状态并返回
         */
        public int[] reset() {
            array = original;
            original = original.clone();
            return array;
        }

        /**
         * 返回数组随机打乱后的结果
         */
        public int[] shuffle() {
            List<Integer> aur = getArrayCopy();
            for (int i = 0; i < array.length; i++) {
                int removeIndex = rand.nextInt(aur.size());
                array[i] = aur.get(removeIndex);
                aur.remove(removeIndex);
            }
            return array;
        }
    }
}
