package test;

import java.util.*;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/5/2
 * 砖墙
 * 垂线不能通过砌墙的两个垂直边缘
 */
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<>();
        //对于每一排的墙
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                //记录当前边缘位置的砖的数量
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        //边缘数量最大 穿过的墙最少
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }
}
