package test;


import java.util.HashMap;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/4/4
 * 森林中的兔子
 */
public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //5  BCDEF  A
            //x个兔子说y个人 至少有  x/y+1种颜色  y+1个人
            // 5       4
            // 3       3
            int x = entry.getValue();
            int y = entry.getKey();
            sum += (x + y) / (y + 1) * (y + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        RabbitsInForest r = new RabbitsInForest();
        System.out.println(r.numRabbits(new int[]{1, 1, 2}));//5
        System.out.println(r.numRabbits(new int[]{10, 10, 10}));//11
        System.out.println(r.numRabbits(new int[]{}));//0
        System.out.println(r.numRabbits(new int[]{1, 0, 1, 0, 0}));//3
    }
}
