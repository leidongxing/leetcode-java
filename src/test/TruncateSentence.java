package test;

/**
 * @author LeiDongxing
 * created on 2021/12/6
 * 截断句子
 */
public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        int n = s.length();
        int end = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0, end);
    }

    public String truncateSentence1(String s, int k) {
        String[] tmp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            sb.append(tmp[i]).append(" ");
        }
        sb.append(tmp[k - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        TruncateSentence ts = new TruncateSentence();
        System.out.println(ts.truncateSentence("Hello how are you Contestant", 4)); //"Hello how are you"
        System.out.println(ts.truncateSentence("What is the solution to this problem", 4));//"What is the solution"
        System.out.println(ts.truncateSentence("chopper is not a tanuki", 5));//"chopper is not a tanuki"
    }
}
