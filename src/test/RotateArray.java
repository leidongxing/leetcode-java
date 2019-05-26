package test;

public class RotateArray {
    //      wrong answer
    //	    public void rotate(int[] nums, int k) {
    //	    	if(nums.length==1) {
    //	    		return;
    //	    	}
    //	    	int[] temp = new int[k];
    //	        for(int i=nums.length-k;i<nums.length;i++) {
    //	        	temp[i-nums.length+k]=nums[i];
    //	        }
    //
    //	    	for(int j=nums.length-1;j>=k;j--) {
    //	            nums[j]=nums[j-k];
    //	    	}
    //
    //	    	for(int m=0;m<k;m++) {
    //	    		nums[m]=temp[m];
    //	    	}
    //
    //	        System.out.println(nums);
    //	    }

    //Brute Force
    //	    public void rotate(int[] nums, int k) {
    //	    	int temp,previous;
    //	    	for(int i=0;i<k;i++) {
    //	    		previous = nums[nums.length-1];
    //	    		for(int j=0;j<nums.length;j++) {
    //	    			temp=nums[j];
    //	    			nums[j]=previous;
    //	    			previous=temp;
    //	    		}
    //	    	}
    //	    	System.out.println(nums);
    //	    }

    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
//		    	if(i+k<nums.length) {
//		    		result[i+k]=nums[i];
//		    	}else {
//		    		result[i+k-nums.length]=nums[i];
//		    	}
            result[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        ra.rotate(new int[]{-1}, 2);
    }
}
