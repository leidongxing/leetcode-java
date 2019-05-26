package test;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left < right) {
            mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        if (nums[left] < target && nums[right] < target) {
            return left + 1;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        SearchInsertPosition si = new SearchInsertPosition();
        System.out.println(si.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(si.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(si.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(si.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
