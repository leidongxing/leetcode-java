package test;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int targetIndex1;
        int targetIndex2 = -1;
        if ((nums1.length + nums2.length) % 2 == 1) {
            targetIndex1 = (nums1.length + nums2.length - 1) / 2;
        } else {
            targetIndex1 = (nums1.length + nums2.length) / 2;
            targetIndex2 = ((nums1.length + nums2.length) / 2) - 1;
        }

        int[] solution = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                solution[k] = nums1[i];
                i++;
            } else {
                solution[k] = nums2[j];
                j++;
            }
            k++;
            if (k == targetIndex1 + 1) {
                return targetIndex2 == -1 ? solution[targetIndex1] : (solution[targetIndex1] + solution[targetIndex2]) / 2d;
            }
        }

        if (i == nums1.length) {
            for (int temp = j; j < nums2.length; j++) {
                solution[k] = nums2[j];
                k++;
                if (k == targetIndex1 + 1) {
                    break;
                }
            }
        } else {
            for (int temp = i; i < nums1.length; i++) {
                solution[k] = nums1[i];
                k++;
                if (k == targetIndex1 + 1) {
                    break;
                }
            }
        }

        return targetIndex2 == -1 ? solution[targetIndex1] : (solution[targetIndex1] + solution[targetIndex2]) / 2d;
    }

    /**
     * Ѱ����λ��
     *
     * @param nums
     * @return
     */
    private double findSortMedian(int[] nums) {
        double numsMedian;
        if (nums.length % 2 == 1) {
            numsMedian = nums[(nums.length - 1) / 2];
        } else {
            numsMedian = (nums[(nums.length / 2)] + nums[(nums.length / 2) - 1]) / 2d;
        }
        return numsMedian;
    }

    /**
     * �鲢����
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] mergeSort(int[] nums1, int[] nums2) {
        int[] solution = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                solution[k] = nums1[i];
                i++;
            } else {
                solution[k] = nums2[j];
                j++;
            }
            k++;
        }

        if (i == nums1.length) {
            for (int temp = j; j < nums2.length; j++) {
                solution[k] = nums2[j];
                k++;
            }
        } else {
            for (int temp = i; i < nums1.length; i++) {
                solution[k] = nums1[i];
                k++;
            }
        }
        for (int s : solution) {
            System.out.print(solution[s] + " ");
        }
        return solution;
    }

    public double findMedianSortedArray(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            findMedianSortedArray(nums2, nums1);
        }
        int imin = 0;
        int imax = nums1.length;
        int half_len = (nums1.length + nums2.length + 1) / 2;
        int i;
        int j;
        int maxLeft;
        int minRight;
        while (imin <= imax) {
            i = (imin + imax) / 2;
            j = half_len - i;
            if (i < nums1.length && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((nums1.length + nums2.length) % 2 == 1) {
                    return maxLeft;
                }

                if (i == nums1.length) {
                    minRight = nums2[j];
                } else if (j == nums2.length) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2d;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        System.out.println(f.findMedianSortedArray(new int[]{1, 3}, new int[]{2})); // 2
        System.out.println(f.findMedianSortedArray(new int[]{1, 2}, new int[]{3, 4})); // 2.5
        System.out.println(f.mergeSort(new int[]{1, 2, 3, 3, 4, 5, 11, 15, 17, 18, 20},
                new int[]{0, 3, 4, 5, 6, 12, 13, 14, 16, 19}));
    }
}
