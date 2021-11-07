package test;

/**
 * @author LeiDongxing
 * created on 2021/11/7
 * 范围求和 II
 */
public class RangeAdditionII {
    /**
     * @param m   长度
     * @param n   宽度
     * @param ops 操作 0<=i<a以及0<=j<b的元素M[i][j]的值都增加1
     * @return 矩阵初始元素为0 返回矩阵中含有最大整数的元素个数
     */
    public int maxCount(int m, int n, int[][] ops) {
        int mina = m, minb = n;
        //维护最小区域
        for (int[] op : ops) {
            mina = Math.min(mina, op[0]);
            minb = Math.min(minb, op[1]);
        }
        return mina * minb;
    }

    public static void main(String[] args) {
        RangeAdditionII r = new RangeAdditionII();
        System.out.println(r.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}));
    }
}
