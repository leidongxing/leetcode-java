package test;

/**
 * @author LeiDongxing
 * created on 2021/8/22
 * 逃脱阻碍者
 */
public class EscapeTheGhosts {
    /**
     * 是否存在比你离target更近的怪 存在则无法挣脱
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int you = manhattanDistance(new int[]{0, 0}, target);
        for (int[] ghost : ghosts) {
            int d = manhattanDistance(ghost, target);
            if (d <= you) {
                return false;
            }
        }
        return true;
    }

    /**
     * 曼哈顿距离
     */
    private int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
