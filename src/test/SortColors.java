package test;

/**
 * @author LeiDongxing
 * created on 2020/10/8
 * 颜色分类
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int ptr = 0;
        //先排0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
        //再排1
        for (int j = ptr; j < nums.length; j++) {
            if (nums[j] == 1) {
                int tmp = nums[j];
                nums[j] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
        //剩下的都是2
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        //0 2 2 1 1 0
        //0 0 2 1 1 2
        //0 0 1 2 1 2
        //0 0 1 1 2 2
        sortColors.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
