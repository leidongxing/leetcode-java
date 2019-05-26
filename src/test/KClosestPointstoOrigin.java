package test;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        int cp = 0;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < points.length; i++) {
            int sum = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (cp < K) {
                result[cp][0] = points[i][0];
                result[cp][1] = points[i][1];
                cp++;
                if (sum > max) {
                    max = sum;
                    maxIndex = cp;
                }
            } else {
                if (sum < max) {
                    result[maxIndex][0] = points[i][0];
                    result[maxIndex][1] = points[i][1];

                }
            }


        }


        return result;
    }
}
