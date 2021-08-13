package test;

/**
 * @author LeiDongxing
 * created on 2021/4/6
 * 删除有序数组中的重复项 II
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    /**
     * 有序数组 nums
     * 原地删除重复出现的元素，使每个元素 最多出现两次
     * 返回删除后数组的新长度
     */
    public int removeDuplicates1(int[] nums) {
        int left = 0;
        int right = 0;
        int index = 0;
        while (left < nums.length) {
            while (right < nums.length && nums[right] == nums[left]) {
                right++;
            }
            if (right - left > 2) {
                //index = index + 2;
                for (int i = 0; i < 2; i++) {
                    nums[index] = nums[left];
                    index++;
                }
                left = right;
            } else {
                if (right > left) {
                    //index = right;
                    for (int i = 0; i < right - left; i++) {
                        nums[index] = nums[left];
                        index++;
                    }
                    left = right;

                } else {
                    nums[index] = nums[left];
                    index++;
                    left++;
                    right = left;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(r.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3})); //5
        System.out.println(r.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));//7
        System.out.println(r.removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));//6
        System.out.println(r.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 2, 2, 4}));//7
    }
}
