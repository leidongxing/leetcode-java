package test;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
         int i = nums.length-2;
         //从后往前找到 一个数   它的后一个数比它大
         while(i>=0 && nums[i+1]<=nums[i]){
             i--;
         }
         if(i>=0){
            int j = nums.length-1;
            //从后往前找 找到第一个比这个数大的数
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            //交换
            swap(nums,i,j);
         }
         //直接转置剩余的
         reverse(nums,i+1);
    }

    private void reverse(int[] nums, int start){
        int i = start,j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
