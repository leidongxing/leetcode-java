package test;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
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


//	int partition(int[] nums,int left,int right) {
//		int p=left;
//		while(left<right) {
//			if(nums[p]>nums[right]) {
//			        int temp =nums[p];
//					nums[p]= nums[right];
//					nums[right]=temp;
//					p=right;
//					right--;	
//					
//					while(nums[left]<nums[p]) {
//						left++;
//					}
//					temp =nums[p];
//					nums[p]= nums[left];
//					nums[left]=temp;
//					p=left;
//					left++;
//			}else {
//				right--;
//			}
//		}	
//		return p;
//	}

    public static void main(String[] args) {
        ArrayPartitionI a = new ArrayPartitionI();
        System.out.println(a.arrayPairSum(new int[]{2, 3, 4, 2, 5, 1, 2, 3}));
    }
}
