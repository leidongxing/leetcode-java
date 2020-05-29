package algorithm;

public class MergeSort {
    public int[] merge(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length+nums2.length];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]<=nums2[p2]){
                result[index]=nums1[p1];
                p1++;
                index++;
            }else{
                result[index]=nums2[p2];
                p2++;
                index++;
            }
        }
        if(p1>=nums1.length){
            for(int i = p2; i<nums2.length;i++){
               result[index]=nums2[i];
               index++;
            }
        }else if(p2>=nums2.length){
            for(int i = p2; i<nums1.length;i++){
                result[index]=nums1[i];
                index++;
            }
        }
        return result;
    }




    public static void main(String[] args){
        MergeSort m = new MergeSort();
        m.merge(new int[]{1,3,5,6,7,8,11,13,14},new int[]{0,2,4,9,10,12,15,16,18});
    }


}
