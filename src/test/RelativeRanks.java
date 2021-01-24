package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/1/24
 * 相对名次
 */
public class RelativeRanks {
    //排序+二分查找
    public String[] findRelativeRanks1(int[] nums) {
        int[] score = new int[nums.length];
        System.arraycopy(nums, 0, score, 0, nums.length);
        Arrays.sort(score);
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int rank = nums.length - Arrays.binarySearch(score, nums[i]);
            if (rank == 1) {
                result[i] = "Gold Medal";
            } else if (rank == 2) {
                result[i] = "Silver Medal";
            } else if (rank == 3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(rank);
            }
        }
        return result;
    }

    //计数排序
    public String[] findRelativeRanks(int[] nums) {
        int max = 0;
        // 找出找出最高的成绩
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        String[] result = new String[nums.length];
        // 下标为成绩，值为成绩在nums的下标
        int[] score = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            score[nums[i]] = i + 1;
        }
        // 记录当前成绩的排名
        int count = 1;
        for (int i = score.length - 1; i >= 0; i--) {
            // 根据排名进行赋值
            if (score[i] != 0) {
                switch (count) {
                    case 1:
                        result[score[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        result[score[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        result[score[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        result[score[i] - 1] = String.valueOf(count);
                }
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RelativeRanks().findRelativeRanks(new int[]{5, 4, 3, 2, 1, 7, 6, 8, 9, 10})));
        System.out.println(Arrays.toString(new RelativeRanks().findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }
}
