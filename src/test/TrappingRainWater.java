package test;

/**
 * @author LeiDongxing
 * created on 2021/2/27
 * 接雨水
 */
public class TrappingRainWater {
    /**
     * 左右指针
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            //左边界小 更新左边界
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }


    /**
     * 动态规划
     */
    public int trap2(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int sum = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        //找到左边最高的
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        //找到右边最高的
        for (int j = height.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }

        for (int k = 0; k < height.length; k++) {
            sum += Math.min(leftMax[k], rightMax[k]) - height[k];
        }
        return sum;
    }


    /**
     * 暴力计算
     */
    public int trap1(int[] height) {
        int sum = 0;
        //计算每一个能接多少水
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            //找到左边最高的
            for (int j = i; j >= 0; j--) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }
            //找到右边最高的
            for (int k = i; k < height.length; k++) {
                if (height[k] > rightMax) {
                    rightMax = height[k];
                }
            }
            //最低的决定能接多少水
            if (leftMax > rightMax) {
                sum += rightMax - height[i];
            } else {
                sum += leftMax - height[i];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));//6
        System.out.println(t.trap(new int[]{4, 2, 0, 3, 2, 5}));//9
    }
}
