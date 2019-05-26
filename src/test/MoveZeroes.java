package test;

public class MoveZeroes {
    //	 public void moveZeroes(int[] nums) {
//		  int[] result = new int[nums.length];
//		  int index=0;
//	      for(int i=0;i<nums.length;i++) {
//	    	  if(nums[i]==0) {
//	    		  index++;
//	    	  }else {
//	    		  result[i-index]=nums[i];
//	    	  }
//	      }
//	      for(int j=nums.length-index+1;j<nums.length;j++) {
//	    	  result[j]=0;
//	      }
//	      nums=result;
//	      System.out.println(nums);
//	 }
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                index++;
            } else {
                nums[i - index] = nums[i];
            }
        }
        for (int j = nums.length - index; j < nums.length; j++) {
            nums[j] = 0;
        }
        System.out.println(nums);
    }


    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
