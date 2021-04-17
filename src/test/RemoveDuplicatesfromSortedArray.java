package test;

/**
 * 删除有序数组中的重复项
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                //替换
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    public int removeDuplicates1(int[] nums) {
        int length = 0;
        int current = 0;
        boolean isDuplicate = false;
        for (int i = 0; i < nums.length; i++) {
            if (!isDuplicate && i + 1 < nums.length && nums[i] == nums[i + 1]) {
                length = i + 1;
                current = nums[i];
                isDuplicate = true;
            } else if (isDuplicate && nums[i] > current) {
                int temp = nums[length];
                nums[length] = nums[i];
                current = nums[i];
                nums[i] = temp;
                length++;
            } else if (!isDuplicate) {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -2, -1, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5};
//		int[] nums = {1,2};
        System.out.println(new RemoveDuplicatesfromSortedArray().removeDuplicates(nums));
    }
}
