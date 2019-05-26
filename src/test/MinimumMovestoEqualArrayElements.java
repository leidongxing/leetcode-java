package test;

public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }
        int res = 0;
        for (int n : nums) {
            res += n - min;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumMovestoEqualArrayElements m = new MinimumMovestoEqualArrayElements();
        System.out.println(m.minMoves(new int[]{1, 2, 3}));
    }
}
