package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2020/11/6
 * 根据数字二进制下 1 的数目排序
 */
public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //bitcount计算1的个数
            result[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        //排序
        Arrays.sort(result);
        for (int i = 0; i < arr.length; i++) {
            result[i] = result[i] % 10000000;
        }
        return result;
    }

    public static void main(String[] args) {
        SortIntegersByTheNumberOf1Bits s = new SortIntegersByTheNumberOf1Bits();
        System.out.println(Arrays.toString(s.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(s.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
        System.out.println(Arrays.toString(s.sortByBits(new int[]{10000, 10000})));
        System.out.println(Arrays.toString(s.sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19})));
        System.out.println(Arrays.toString(s.sortByBits(new int[]{10, 100, 1000, 10000})));
    }
}
