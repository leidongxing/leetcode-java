package test;

/**
 * @author LeiDongxing
 * created on 2021/1/17
 * 缀点成线
 */
public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        boolean result = getSameSlope(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1], coordinates[2][0], coordinates[2][1]);
        if (!result) {
            return false;
        }
        for (int i = 1; i + 2 < coordinates.length; i++) {
            result = getSameSlope(coordinates[i][0], coordinates[i][1], coordinates[i + 1][0], coordinates[i + 1][1], coordinates[i + 2][0], coordinates[i + 2][1]);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    public boolean getSameSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (x1 == x2 && x1 == x3) {
            return true;
        }
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }


    public static void main(String[] args) {
        System.out.println(new CheckIfItIsAStraightLine().checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        System.out.println(new CheckIfItIsAStraightLine().checkStraightLine(new int[][]{{-4, -3}, {1, 0}, {3, -1}, {0, -1}, {-5, 2}}));
    }
}
