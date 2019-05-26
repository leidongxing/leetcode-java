package test;

public class ContainerWithMostWater implements Solution {

    public int maxArea(int[] height) {
        int capability = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int water = Math.min(height[left], height[right]) * (right - left);

            if (water > capability) capability = water;

            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return capability;
    }

    @Override
    public void doIt() {
        System.out.println(this.maxArea(new int[]{1, 1}));// 1
        System.out.println(this.maxArea(new int[]{0, 2}));// 0
        System.out.println(this.maxArea(new int[]{3, 2, 1, 3})); // 9
        System.out.println(this.maxArea(new int[]{1, 2, 4, 3}));// 4
        System.out.println(this.maxArea(new int[]{10, 14, 10, 4, 10, 2, 6, 1,
                6, 12})); // 96
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        new ClacTimeThread(c).run();
    }
}
