package test;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            if (A[low] % 2 == 1) {
                while (A[high] % 2 != 0 && high > low) {
                    high--;
                }
                if (low >= high) {
                    break;
                } else {
                    int temp = A[low];
                    A[low] = A[high];
                    A[high] = temp;
                }
            }
            low++;
        }
        return A;
    }

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        sortArrayByParity.sortArrayByParity(new int[]{1, 3});
    }
}
