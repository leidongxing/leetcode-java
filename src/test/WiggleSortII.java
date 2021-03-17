package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/3/17
 * 摆动排序 II
 */
public class WiggleSortII {
//    public void wiggleSort(int[] nums) {
//        int[] tmp = nums.clone();
//        Arrays.sort(tmp);
//        int n = nums.length - 1;
//        for (int i = 1; i < nums.length; i += 2) {
//            nums[i] = tmp[n];
//            n--;
//        }
//        for (int i = 0; i < nums.length; i += 2) {
//            nums[i] = tmp[n];
//            n--;
//        }
//    }

    int n=-1;
    public void wiggleSort(int[] nums) {
        //找到中位数索引
        int midIndex = this.quickSelect(nums,0,nums.length-1);
        //找到中位数
        int mid = nums[midIndex];
        n=nums.length;
        //三分法
        for(int i=0,j=0,k=nums.length-1;j<=k;){
            if(nums[V(j)]>mid){
                swap(nums,V(j++),V(i++));
            }else if(nums[V(j)]<mid){
                swap(nums,V(j),V(k--));
            }else{
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public int V(int i){
        return (1+2*(i)) % (n|1);
    }

    public void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public int quickSelect(int[] nums,int left,int right){
        int pivot = nums[left];
        int l = left;
        int r = right;
        while(l<r){
            while(l<r&&nums[r]>=pivot){
                r--;
            }
            if(l<r){
                nums[l++]=nums[r];
            }
            while(l<r&&nums[l]<=pivot){
                l++;
            }
            if(l<r){
                nums[r--]=nums[l];
            }
        }
        nums[l]=pivot;
        if(l==nums.length/2){
            return l;
        }else if(l>nums.length/2){
            return this.quickSelect(nums,left,l-1);
        }else{
            return this.quickSelect(nums,l+1,right);
        }
    }

    public static void main(String[] args) {
        new WiggleSortII().wiggleSort(new int[]{1, 5, 1, 1, 6, 4});//1,6,1,5,1,4   1,4,1,5,1,6
        new WiggleSortII().wiggleSort(new int[]{1, 3, 2, 2, 3, 1});//2,3,1,3,1,2
    }
}
