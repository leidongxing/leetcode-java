package test;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
//      wrong answer   
//    	int max=0;
//    	int left=0;
//    	int right=nums.length-1;
//    	int maxN =Integer.MIN_VALUE;
//    	while(left<right) {
//    		while(left<right && nums[left]<=0) {
//    			maxN=Math.max(maxN, nums[left]);
//    			left++;
//    		}
//    		while(left+2<right && nums[left+1]+nums[left]<0) {
//    			maxN=Math.max(maxN, nums[left+1]);	
//    			left=left+2;
//    				
//    		}
//    		
//    		while(left<right && nums[right]<=0) {
//    			maxN=Math.max(maxN, nums[right]);
//    			right--;
//    		}
//			while(left<right-2 && nums[right-1]+nums[right]<0) {
//				maxN=Math.max(maxN, nums[right-1]);	
//				right=right-2;
//			}
//    		break;
//    	}
//    	if(left==right && nums[left]<0) {
//    		return maxN;
//    	}
//        
//    	for(int i=left;i<=right;i++) {
//    		max+=nums[i];
//    	}
//    	
//    	return max;


        //brute force
//    	if(nums.length==1) {
//    		return nums[0];
//    	}
//    	int max = Integer.MIN_VALUE;
//    	int sum = 0;
//    	for(int i=0;i<nums.length;i++) {
//    		sum=nums[i];
//    		max=Math.max(max, sum);
//    		for(int j=i+1;j<nums.length;j++) {
//    			sum+=nums[j];
//    			max = Math.max(max,sum);
//    		}
//    	}
//    	return max;


        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;


    }


    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
