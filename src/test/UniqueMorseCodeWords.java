package test;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> Set = new HashSet<String>();
        String[] letter = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (String s : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {
                stringBuilder.append(letter[(int) c - 'a']);
            }
            Set.add(stringBuilder.toString());
        }
        return Set.size();
    }

    public static void main(String[] args) {
        UniqueMorseCodeWords uniqueMorseCodeWords = new UniqueMorseCodeWords();
        System.out.println(uniqueMorseCodeWords.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));

    }

}
