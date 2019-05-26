package test;

public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                index = i;
                max = A[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        PeakIndexinaMountainArray p = new PeakIndexinaMountainArray();
        p.peakIndexInMountainArray(new int[]{0, 0, 0});
        p.peakIndexInMountainArray(new int[]{0, 1, 0});
        p.peakIndexInMountainArray(new int[]{0, 2, 1, 0});
        p.peakIndexInMountainArray(new int[]{3, 4, 5, 1});//2
    }
}
