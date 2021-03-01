package test;

import java.util.Arrays;

/**
 * 缺失的第一个正数
 * 要求 时间复杂度O(n) 空间复杂度O(1)
 */
public class FirstMissingPositive {

    //排序 然后查找
    public int firstMissingPositive1(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        nums = quickSort(nums, 0, nums.length - 1);
        int begin = nums[0];
        int end = nums[nums.length - 1];
        if (end <= 0) {
            return 1;
        }
        if (begin > 1) {
            return 1;
        }
        int i = 0;
        while (i < nums.length && nums[i] <= 0) {
            i++;
        }
        if (nums[i] > 1) {
            return 1;
        }
        int min = 1;
        i++;
        while (i < nums.length) {
            if (nums[i] == min) {
                i++;
            } else if (nums[i] == min + 1) {
                min++;
            } else {
                return min + 1;
            }
        }
        return min + 1;
    }

    int[] quickSort(int[] nums, int left, int right) {
        int p = 0;
        if (left < right) {
            p = partition(nums, left, right);
            quickSort(nums, left, p - 1);
            quickSort(nums, p + 1, right);
        }
        return nums;
    }

    int partition(int[] nums, int left, int right) {
        int key = nums[left];
        while (left < right) {


            while (left < right && nums[right] >= key) {
                right--;
            }
            nums[left] = nums[right];


            while (left < right && nums[left] <= key) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        return left;
    }

    //两重循环
    public int firstMissingPositive2(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < nums.length; j++) {
                if (i == nums[j]) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                return i;
            }
        }
        return nums.length + 1;
    }


    //置换  缺失的第一个正数
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //不断交换当前值 存在其对应的下标处
        for (int i = 0; i < n; i++) {
            //当前值大于0  当前值小于总的  不在下标下
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        //再次遍历 下标不正确的即为所求值
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        System.out.println(fmp.firstMissingPositive(new int[]{1, 2, 0}));//3
        System.out.println(fmp.firstMissingPositive(new int[]{3, 4, -1, 1}));//2
        System.out.println(fmp.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));//1
        System.out.println(fmp.firstMissingPositive(new int[]{-1, 2}));//1
    }
}
