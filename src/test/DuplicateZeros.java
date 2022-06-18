package test;

/**
 * @author LeiDongxing
 * created on 2022/6/18
 * 复写零
 */
public class DuplicateZeros {


    /**
     * arr[i]左边有几个零 就要向右边移动几位
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int leftCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                leftCount++;
            }
        }
        //从后向前遍历
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                leftCount--;
            }
            //不出界
            if (i + leftCount < n) {
                arr[i + leftCount] = arr[i];
                //当前位置是0
                if (arr[i] == 0 && i + leftCount + 1 < n) {
                    arr[i + leftCount + 1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        new DuplicateZeros().duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});//1,0,2,3,0,4,5,0
        new DuplicateZeros().duplicateZeros(new int[]{1, 2, 3});//1,2,3
    }
}
