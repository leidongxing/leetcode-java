package test;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // if (strs.length == 0) {
        // return "";
        // } else if (strs.length == 1) {
        // return strs[0];
        // } else {
        // StringBuilder sb = new StringBuilder();
        // int minLength = strs[0].length();
        // for (int i = 1; i < strs.length; i++) {
        // if (strs[i].length() < minLength) {
        // minLength = strs[i].length();
        // }
        // }
        // for (int i = 0; i < minLength; i++) {
        // char c = strs[0].charAt(i);
        // for (int j = 1; j < strs.length; j++) {
        // if (strs[j].charAt(i) != c) {
        // return sb.toString();
        // }
        // }
        // sb.append(c);
        // }
        // return sb.toString();
        // }
        StringBuilder sb = new StringBuilder();
        if (strs != null && strs.length > 0) {
            Arrays.sort(strs);
            char[] first = strs[0].toCharArray();
            char[] last = strs[strs.length - 1].toCharArray();
            for (int i = 0; i < first.length; i++) {
                if (last.length > i && first[i] == last[i]) {
                    sb.append(last[i]);
                } else {
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new LongestCommonPrefix().longestCommonPrefix(new String[]{});
        System.out.println(new LongestCommonPrefix()
                .longestCommonPrefix(new String[]{"bbaaaa", "aaaa", "ass",
                        "b"}));
    }
}
