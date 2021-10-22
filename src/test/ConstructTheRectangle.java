package test;

/**
 * @author LeiDongxing
 * created on 2021/10/23
 * 构造矩形
 */
public class ConstructTheRectangle {
    //矩形页面必须等于给定的目标面积
    //L>= W
    //长度L和宽度W之间的差距应当尽可能小
    public int[] constructRectangle(int area) {
        int start = (int) Math.sqrt(area);
        for (int i = start; i > 0; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        return new int[]{};
    }

}
