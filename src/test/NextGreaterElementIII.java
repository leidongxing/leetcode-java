package test;

/**
 * @author LeiDongxing
 * created on 2022/7/3
 * 下一个更大元素 III
 */
public class NextGreaterElementIII {


    /**
     * 下一个更大元素 III
     *
     * @param n
     * @return 请你找出符合条件的最小整数 并且其值大于n
     */
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
        long result = Long.parseLong(new String(nums));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    private void reverse(char[] nums, int begin) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        NextGreaterElementIII n = new NextGreaterElementIII();
        System.out.println(n.nextGreaterElement(12));//21
        System.out.println(n.nextGreaterElement(21));//-1
        System.out.println(n.nextGreaterElement(12354));//12435
    }
}
