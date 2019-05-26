package test;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
//	public int mincostTickets(int[] days, int[] costs) {
//		if (days.length == 1) {
//			return costs[0];
//		}
//		int sum = 0;
//		int end = 0;
//		int index = 0;
//		int diff = 0;
//		int sum0 = 0, sum1 = 0, sum2 = 0;
//		int end0 = 0, end1 = 0, end2 = 0;
//		int avg0 = 0, avg1 = 0, avg2 = 0;
//		while (index < days.length) {
//			sum0 = sum + costs[0];
//			end0 = end + 1;
//			diff = days[index];
//			avg0 = sum0 / (findDays(end0, days) + 1);
//
//			sum1 = sum + costs[1];
//			end1 = end + 7;
//			avg1 = sum1 / (findDays(end1, days) + 1);
//
//			sum2 = sum + costs[2];
//			end2 = end + 30;
//			avg2 = sum2 / (findDays(end2, days) + 1);
//
//			if (avg0 < avg1 && avg0 < avg2) {
//				end = end0;
//				sum = sum0;
//			} else if (avg1 < avg0 && avg1 < avg2) {
//				end = end1;
//				sum = sum1;
//			} else if (avg2 < avg0 && avg2 < avg1) {
//				end = end2;
//				sum = sum2;
//			}
//			index++;
//		}
//		return sum;
//	}
//
//	int findDays(int target, int nums[]) {
//		int low = 0;
//		int high = nums.length;
//		int mid = -1;
//		while (low < high) {
//			mid = (low + high) / 2;
//			if (target > nums[mid]) {
//				low = mid + 1;
//			} else if (target < nums[mid]) {
//				high = mid - 1;
//			} else {
//				return mid;
//			}
//		}
//		if (target < nums[low]) {
//			return low - 1;
//		}
//		return low;
//	}

    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet<Integer>();
        for (int d : days) {
            dayset.add(d);
        }
        return dp(1);
    }

    public int dp(int i) {
        if (i > 365) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        int ans;
        if (dayset.contains(i)) {
            ans = Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]);
            ans = Math.min(dp(i + 30) + costs[2], ans);
        } else {
            ans = dp(i + 1);
        }
        memo[i] = ans;
        return ans;
    }


    public static void main(String[] args) {
        MinimumCostForTickets m = new MinimumCostForTickets();
        System.out.println(m.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }
}
