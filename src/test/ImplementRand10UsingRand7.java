package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/9/5
 * 用 Rand7()实现Rand10()
 */
public class ImplementRand10UsingRand7 {

    /**
     * 拒绝采样 生成的随机数满足要求就返回 否则不断生成直到生成一个满足要求的随机数
     */
    public int rand10() {
        int row, col, idx;
        do {
            //1-7
            row = rand7();
            //1-7
            col = rand7();
            //乘积是1-49 取前40个数
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    /**
     * rand7 可生成1到7范围内的均匀随机整数
     */
    private int rand7() {
        return (int) (Math.random() * 7 + 1);
    }

    public static void main(String[] args) {
        ImplementRand10UsingRand7 iru = new ImplementRand10UsingRand7();
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < 100000000; i++) {
            int r = iru.rand7();
            map1.put(r, map1.getOrDefault(r, 0) + 1);
        }
        System.out.println(map1);

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 100000000; i++) {
            int r = iru.rand10();
            map2.put(r, map2.getOrDefault(r, 0) + 1);
        }
        System.out.println(map2);
    }
}
