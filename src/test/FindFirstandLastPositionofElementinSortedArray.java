package test;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                first = mid;
                last = mid;
                while (first >= 0 && target == nums[first]) {
                    first--;
                }
                first++;
                while (last <= nums.length - 1 && target == nums[last]) {
                    last++;
                }
                last--;
                break;
            }
        }
        int[] result = new int[2];
        result[0] = first;
        result[1] = last;
        return result;
    }

    public static void main(String[] args) {
        FindFirstandLastPositionofElementinSortedArray f = new FindFirstandLastPositionofElementinSortedArray();
//		 System.out.println(f.searchRange(new int[] {5,7,7,8,8,10}, 8));
//		 System.out.println(f.searchRange(new int[] {5,7,7,8,8,10}, 6));
        System.out.println(f.searchRange(new int[]{2, 2}, 2));
//		 System.out.println(f.searchRange(new int[] {1}, 1));
    }
}
