package test;

public class MaximumProductSubarray {
//	 public int maxProduct(int[] nums) {
//	   int sum =1;
//	   int max = nums[0];
//	   for(int i=0;i<nums.length;i++) {	  
//		   if(max>0 &&nums[i]==0) {
//			   continue;
//		   }
//		   sum=nums[i];
//		   if(sum>max) {
//			   max=sum;
//		   }
//		   
//		   for(int j=i+1;j<nums.length;j++) {
//			   if(max>0 && nums[j]==0){
//				   break;
//			   }
//			   sum=sum*nums[j];
//			   if(sum>max) {
//				   max=sum;
//			   }
//			   
//		   }
//	   }
//	   return max;
//	 }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxherepre = nums[0];
        int minherepre = nums[0];
        int maxsofar = nums[0];
        int maxhere, minhere;

        for (int i = 1; i < nums.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return maxsofar;
    }


    public static void main(String[] args) {
        MaximumProductSubarray mp = new MaximumProductSubarray();
//		 System.out.println(mp.maxProduct(new int[] {2,3,-2,4}));
        System.out.println(mp.maxProduct(new int[]{-2, 0, -1, 4, 8}));
//		 System.out.println(mp.maxProduct(new int[] {-2,0,-1}));
//		 System.out.println(mp.maxProduct(new int[] {0,2}));
    }
}
