package test;

/**
 * @author LeiDongxing
 * created on 2021/3/23
 * 数组异或操作
 */
public class XOROperationInAnArray {
    public int xorOperation(int n, int start) {
        int result = start;
        int tmp;
        for (int i = 1; i < n; i++) {
            tmp = start + 2 * i;
            result ^= tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        XOROperationInAnArray x = new XOROperationInAnArray();
        System.out.print(x.xorOperation(5, 0));
    }
}
