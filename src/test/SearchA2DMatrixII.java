package test;

/**
 * @author LeiDongxing
 * created on 2021/10/25
 * 搜索二维矩阵 II
 */
public class SearchA2DMatrixII {
    //每行的元素从左到右升序排列。
    //每列的元素从上到下升序排列
    public boolean searchMatrix(int[][] matrix, int target) {
        //选左上角，往右走和往下走都增大，不能选
        //选右下角，往上走和往左走都减小，不能选
        //选左下角，往右走增大，往上走减小，可选
        //选右上角，往下走增大，往左走减小，可选
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                //右上角 左走
                row--;
            }else if(matrix[row][col]<target){
                //右上脚 下走
                col++;
            }else {
                return true;
            }
        }
        return false;
    }
}
