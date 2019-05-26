package test;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    public String toGoatLatin(String S) {
        char[] sChar = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Character> vowel = new HashSet<Character>();
        vowel.add('a');
        vowel.add('A');
        vowel.add('e');
        vowel.add('E');
        vowel.add('i');
        vowel.add('I');
        vowel.add('o');
        vowel.add('O');
        vowel.add('u');
        vowel.add('U');
        int index = 0;
        boolean isBegin = true;
        boolean isVowel = false;
        char consonant = '/';
        for (int i = 0; i < sChar.length; i++) {
            if (isBegin) {
                if (vowel.contains(sChar[i])) {
                    isVowel = true;
                    sb.append(sChar[i]);
                } else {
                    isVowel = false;
                    consonant = sChar[i];
                }
                isBegin = false;
            } else if (sChar[i] == ' ') {
                if (isVowel) {
                    sb.append("ma");
                    isVowel = false;
                } else {
                    sb.append(consonant);
                    sb.append("ma");
                    consonant = '/';
                }
                index++;
                for (int j = 0; j < index; j++) {
                    sb.append('a');
                }
                sb.append(' ');
                isBegin = true;
            } else {
                sb.append(sChar[i]);
            }
        }


        if (isVowel) {
            sb.append("ma");
        } else {
            sb.append(consonant);
            sb.append("ma");
        }
        index++;
        for (int j = 0; j < index; j++) {
            sb.append('a');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        GoatLatin g = new GoatLatin();
        System.out.println(g.toGoatLatin("HZ sg L"));
    }
}
