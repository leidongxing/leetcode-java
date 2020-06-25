package test;


import java.util.*;

/**
 * @author LeiDongxing
 * create on 2020/6/25 15:59
 * 单词拆分
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //从j到i的都是
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));//true
        System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen")));//true
        System.out.println(wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));//false
        System.out.println(wordBreak.wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb")));//true
        System.out.println(wordBreak.wordBreak("cars", Arrays.asList("car", "ca", "rs")));//true
    }
}
