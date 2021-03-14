package test;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/3/14
 * 直线上最多的点数
 */
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        //两个点最多两条线
        if (points.length < 3) {
            return points.length;
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            int max = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] = points[i][1];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(result, max + duplicate + 1);
            }
        }
        return result;
    }

    /**
     * 获取最大公约数
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
