package test;

public class FirstMissingPositive {

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

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
                i++;
            } else if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
//		System.out.println(fmp.firstMissingPositive(new int[] {1,2,0}));
//		System.out.println(fmp.firstMissingPositive(new int[] {3,4,-1,1}));
        System.out.println(fmp.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(fmp.firstMissingPositive(new int[]{-1, 2}));
    }
}
