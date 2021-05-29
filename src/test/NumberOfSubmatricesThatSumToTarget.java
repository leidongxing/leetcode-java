package test;

/**
 * @author LeiDongxing
 * created on 2021/5/29
 * 元素和为目标值的子矩阵数量
 */
public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] record = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < record.length; i++) {
            for (int j = 1; j < record[0].length; j++) {
                record[i][j] = record[i - 1][j] + record[i][j - 1] - record[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int result = 0;
        // i,j 右下方边界，k,t 左上方边界。
        for(int i = 1; i < record.length; ++i){
            for(int j = 1; j < record[0].length; ++j){
                for(int k = 0; k < i; ++k){
                    for(int t = 0; t < j; ++t){
                        if((record[i][j]-record[k][j]-record[i][t]+record[k][t]) == target){
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
