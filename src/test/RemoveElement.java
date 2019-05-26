package test;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int lastIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && i < lastIndex) {
                while (i < lastIndex && nums[lastIndex] == val) {
                    lastIndex--;
                }
                int temp = nums[lastIndex];
                nums[lastIndex] = val;
                nums[i] = temp;
                lastIndex--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "、");
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3, 2};
        int[] nums2 = {-2, -2, -1, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5};
        int[] nums3 = {3};
        int[] nums4 = {2, 2, 2};
        System.out.println(new RemoveElement().removeElement(nums3, 0));
    }
}
