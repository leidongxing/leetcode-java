package test;

public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        quickSort(A, 0, A.length - 1);
        int result = A[A.length - 1] - A[0];
        if (result <= 2 * K) {
            return 0;
        }
        return result - 2 * K;
    }

    int[] quickSort(int[] A, int left, int right) {
        int p = 0;
        if (left < right) {
            p = partition(A, left, right);
            quickSort(A, left, p - 1);
            quickSort(A, p + 1, right);
        }
        return A;
    }

    int partition(int[] A, int left, int right) {
        int key = A[left];
        while (left < right) {
            while (left < right && A[right] >= key) {
                right--;
            }
            A[left] = A[right];
            while (left < right && A[left] <= key) {
                left++;
            }
            A[right] = A[left];
        }
        A[left] = key;
        return left;
    }


//	 public int smallestRangeI(int[] A, int K) {
//	        int min = A[0], max = A[0];
//	        for (int x: A) {
//	            min = Math.min(min, x);
//	            max = Math.max(max, x);
//	        }
//	        return Math.max(0, max - min - 2*K);
//	    }

    public static void main(String[] args) {
        SmallestRangeI r = new SmallestRangeI();
        System.out.println(r.smallestRangeI(new int[]{1, 3, 6}, 3));
    }
}
