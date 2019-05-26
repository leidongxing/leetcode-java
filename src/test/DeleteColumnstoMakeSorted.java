package test;

public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        int sum = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if ((int) A[j].charAt(i) > (int) A[j + 1].charAt(i)) {
                    sum++;
                    break;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        DeleteColumnstoMakeSorted deleteColumnstoMakeSorted = new DeleteColumnstoMakeSorted();
        System.out.println(deleteColumnstoMakeSorted.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        System.out.println(deleteColumnstoMakeSorted.minDeletionSize(new String[]{"a", "b"}));
        System.out.println(deleteColumnstoMakeSorted.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
        System.out.println(deleteColumnstoMakeSorted.minDeletionSize(new String[]{"rrjk", "furt", "guzm"}));

    }

}
