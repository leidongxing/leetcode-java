package test;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> al = new ArrayList<String>();
        al.add(S);
        char[] sChar = S.toCharArray();
        System.out.println((int) 'A'); //65
        System.out.println((int) 'Z'); //90
        System.out.println((int) 'a');
        System.out.println((int) 'z');

        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] <= 'Z' && sChar[i] >= 'A') {
                char c = (char) (sChar[i] + 32);
                StringBuilder sb = new StringBuilder();
                sb.append(c);
            } else if (sChar[i] <= 'z' && sChar[i] >= 'a') {
                char c = (char) (sChar[i] - 32);

            } else {

            }
        }


        return al;


    }
}
