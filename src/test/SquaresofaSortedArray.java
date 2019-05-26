package test;

public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int[] temp = new int[A.length];
        int index = 0;
        if (Math.abs(A[left]) > Math.abs(A[right])) {
            temp[0] = A[left] * A[left];
            left++;
        } else {
            temp[0] = A[right] * A[right];
            right--;
        }

        while (left <= right) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                index++;
                temp[index] = A[left] * A[left];
                left++;
            } else if (Math.abs(A[left]) < Math.abs(A[right])) {
                index++;
                temp[index] = A[right] * A[right];
                right--;
            } else {
                index++;
                temp[index] = A[right] * A[right];
                right--;
            }
        }
        int[] result = new int[index + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp[temp.length - 1 - i];
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresofaSortedArray s = new SquaresofaSortedArray();
//		int[] a = new int[] { 1, 2, 3 };
        // int[] a =new int[] {-6,-5,-3,-2,-1};
        int[] a = new int[]{-7, -3, 2, 3, 11};
        a = s.sortedSquares(a);
        System.out.println(a);
    }
}
