package test;

import java.util.LinkedList;
import java.util.List;

public class SubstringWithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> al = new LinkedList<Integer>();
        List<String> wordsList = new LinkedList<String>();
        for (int i = 0; i < words.length; i++) {
            wordsList.add(words[i]);
        }

        return al;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationofAllWords sc = new SubstringWithConcatenationofAllWords();
        System.out.println(sc.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));  //[0,9]
    }
}
