package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/3/28
 * 移动石子直到连续 II
 */
public class MovingStonesUntilConsecutiveII {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int[] result = new int[2];

        return result;
    }

    public static void main(String[] args) {
        MovingStonesUntilConsecutiveII m = new MovingStonesUntilConsecutiveII();
        System.out.println(Arrays.toString(m.numMovesStonesII(new int[]{7, 4, 9})));//4 7 9  7 8 9  [1,2]
        System.out.println(Arrays.toString(m.numMovesStonesII(new int[]{6, 5, 4, 3, 10})));//3 4 5 6 10 [2,3]
        System.out.println(Arrays.toString(m.numMovesStonesII(new int[]{100, 101, 104, 102, 103}))); //[0,0]
    }
}
