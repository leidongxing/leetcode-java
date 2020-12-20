package test;

/**
 * @author LeiDongxing
 * created on 2020/12/20
 * 去除重复字母
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] char2Num = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            char2Num[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            //没有访问过
            if (!visited[c - 'a']) {
                //删除在它之前 比他它小的加入的
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                    char last = sb.charAt(sb.length() - 1);
                    if (char2Num[last - 'a'] > 0) {
                        visited[last - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                visited[c - 'a'] = true;
                sb.append(c);
            }
            char2Num[c - 'a'] -= 1;
        }
        return sb.toString();
    }
}
