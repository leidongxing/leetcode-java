package test;

public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int max = S.length();
        int min = 0;
        int[] result = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                result[i] = min;
                min++;
            } else {
                result[i] = max;
                max--;
            }
        }
        result[S.length()] = max;
        return result;
    }

    public static void main(String[] args) {
        DIStringMatch d = new DIStringMatch();
        d.diStringMatch(new String("DDI"));
    }
}
