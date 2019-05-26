package test;

public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if ('A' <= a[i] && a[i] <= 'Z') {
                a[i] = (char) (a[i] - 'A' + 'a');
            }
        }
        return new String(a);

    }

    public static void main(String[] args) {
        ToLowerCase toLowerCase = new ToLowerCase();
        System.out.println(toLowerCase.toLowerCase("LOVELY"));
    }
}
