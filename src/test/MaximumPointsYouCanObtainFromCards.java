package test;

/**
 * @author LeiDongxing
 * created on 2021/2/6
 * 可获得的最大点数
 */
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int p : cardPoints) {
            sum += p;
        }
        //不管 从行的开头/末尾拿 都存在 cardPoints-k的滑动窗口在移动
        int result = 0;
        int wSum = 0;
        for (int i = 0; i < cardPoints.length - k; i++) {
            wSum += cardPoints[i];
        }
        result = sum - wSum;
        for (int i = 0; i < k; i++) {
            wSum -= cardPoints[i];
            wSum += cardPoints[cardPoints.length - k + i];
            result = Math.max(result, sum - wSum);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{2, 2, 2}, 3));
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{1, 1000, 1}, 1));
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }
}
