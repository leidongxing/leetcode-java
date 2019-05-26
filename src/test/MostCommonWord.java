package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedset = new HashSet<String>();
        for (String s : banned) {
            bannedset.add(s);
        }
        char[] pc = paragraph.toCharArray();
        Queue<Character> q = new LinkedList<Character>();
        Map<String, Integer> string2times = new HashMap<String, Integer>();
        for (int i = 0; i < pc.length; i++) {
            if ((pc[i] >= 'A' && pc[i] <= 'Z') || (pc[i] >= 'a' && pc[i] <= 'z')) {
                q.add(pc[i]);
            } else {
                StringBuilder sb = new StringBuilder();
                while (!q.isEmpty()) {
                    char cur = q.peek();
                    if (cur >= 'A' && cur <= 'Z') {
                        cur = (char) (cur + 32);
                    }
                    sb.append(cur);
                    q.poll();
                }
                if (sb.length() != 0) {
                    if (bannedset.contains(sb.toString())) {
                        continue;
                    }
                    if (string2times.containsKey(sb.toString())) {
                        string2times.put(sb.toString(), string2times.get(sb.toString()) + 1);
                    } else {
                        string2times.put(sb.toString(), 1);
                    }
                }
            }
        }
        if (!q.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                char cur = q.peek();
                if (cur >= 'A' && cur <= 'Z') {
                    cur = (char) (cur + 32);
                }
                sb.append(cur);
                q.poll();
            }
            if (!bannedset.contains(sb.toString())) {
                if (string2times.containsKey(sb.toString())) {
                    string2times.put(sb.toString(), string2times.get(sb.toString()) + 1);
                } else {
                    string2times.put(sb.toString(), 1);
                }
            }
        }

        int max = 0;
        String result = "";
        for (Entry<String, Integer> e : string2times.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                result = e.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println((int)'Z');
        // System.out.println((int)'A');
        // System.out.println((int)'a');
        // System.out.println((int)'z');
        MostCommonWord m = new MostCommonWord();
//		System.out.println(
//				m.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" }));
        System.out.println(m.mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"}));

    }
}
