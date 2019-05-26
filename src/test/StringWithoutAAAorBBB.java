package test;

public class StringWithoutAAAorBBB {
    public String strWithout3a3b(int A, int B) {
        StringBuilder s = new StringBuilder();
        int capacity = A + B;
        if (A == B) {
            while (A > 0) {
                s.append("a");
                s.append("b");
                A--;
            }
        } else if (A > B) {
            while (A > 0 && A - B > 0) {
                s.append("aa");
                s.append("b");
                A -= 2;
                B--;
            }
            while (A > 0) {
                s.append("a");
                s.append("b");
                A--;
            }
            if (s.length() > capacity) {
                s.delete(s.length() - (s.length() - capacity), s.length());
            }
        } else {
            while (B > 0 && B - A > 0) {
                s.append("bb");
                s.append("a");
                B -= 2;
                A--;
            }
            while (B > 0) {
                s.append("b");
                s.append("a");
                B--;
            }
            if (s.length() > capacity) {
                s.delete(s.length() - (s.length() - capacity), s.length());
            }

        }
        return s.toString();
    }

    public static void main(String[] args) {
        StringWithoutAAAorBBB s = new StringWithoutAAAorBBB();
//		System.out.println(s.strWithout3a3b(2, 2));
        System.out.println(s.strWithout3a3b(3, 3));
//		System.out.println(s.strWithout3a3b(1, 4));
    }
}
