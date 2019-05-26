package test;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            } else {
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray fr = new FindMinimuminRotatedSortedArray();
        System.out.println(fr.findMin(new int[]{1, 2}));
    }
}
