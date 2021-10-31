package test;

import java.util.*;

/**
 * 键盘行
 */
public class KeyboardRow {
    /**
     * 返回可以使用在 美式键盘 同一行的字母打印出来的单词
     */
    public String[] findWords1(String[] words) {
        if (words.length == 0) {
            return new String[]{};
        }
        String[] result = new String[words.length];
        Set<Character> cs1 = new HashSet<Character>();
        cs1.add('Q');
        cs1.add('q');
        cs1.add('W');
        cs1.add('w');
        cs1.add('E');
        cs1.add('e');
        cs1.add('R');
        cs1.add('r');
        cs1.add('T');
        cs1.add('t');
        cs1.add('Y');
        cs1.add('y');
        cs1.add('U');
        cs1.add('u');
        cs1.add('I');
        cs1.add('i');
        cs1.add('O');
        cs1.add('o');
        cs1.add('P');
        cs1.add('p');

        Set<Character> cs2 = new HashSet<Character>();
        cs2.add('A');
        cs2.add('a');
        cs2.add('S');
        cs2.add('s');
        cs2.add('D');
        cs2.add('d');
        cs2.add('F');
        cs2.add('f');
        cs2.add('G');
        cs2.add('g');
        cs2.add('H');
        cs2.add('h');
        cs2.add('J');
        cs2.add('j');
        cs2.add('K');
        cs2.add('k');
        cs2.add('L');
        cs2.add('l');

        Set<Character> cs3 = new HashSet<Character>();
        cs3.add('Z');
        cs3.add('z');
        cs3.add('X');
        cs3.add('x');
        cs3.add('C');
        cs3.add('c');
        cs3.add('V');
        cs3.add('v');
        cs3.add('B');
        cs3.add('b');
        cs3.add('N');
        cs3.add('n');
        cs3.add('M');
        cs3.add('m');

        boolean isMatch = true;
        int i = 0;
        for (String word : words) {
            char[] w = word.toCharArray();
            if (cs1.contains(w[0])) {
                for (int j = 0; j < w.length; j++) {
                    if (!cs1.contains(w[j])) {
                        isMatch = false;
                        break;
                    }
                }
            } else if (cs2.contains(w[0])) {
                for (int j = 0; j < w.length; j++) {
                    if (!cs2.contains(w[j])) {
                        isMatch = false;
                        break;
                    }
                }
            } else {
                for (int j = 0; j < w.length; j++) {
                    if (!cs3.contains(w[j])) {
                        isMatch = false;
                        break;
                    }
                }
            }
            if (isMatch) {
                result[i] = word;
                i++;
            }
            isMatch = true;
        }
        return Arrays.copyOf(result, i);
    }


    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        //为26个英文字母标记行号 第0 1 2行
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            char idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) - 'a');
            for (int i = 1; i < word.length(); i++) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) - 'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                list.add(word);
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        KeyboardRow k = new KeyboardRow();
        System.out.println(Arrays.toString(k.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
      //  System.out.println(Arrays.toString(k.findWords(new String[]{"asdfghjkl", "qwertyuiop", "zxcvbnm"})));
    }


}
