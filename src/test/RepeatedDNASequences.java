package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 重复的DNA序列
 */
public class RepeatedDNASequences {
    /**
     * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在DNA字符串s中出现次数超过一次。
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> cnt = new HashMap<>();
        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            String sub = s.substring(i, i + 10);
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if (cnt.get(sub) == 2) {
                result.add(sub);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));//["AAAAACCCCC","CCCCCAAAAA"]
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAAAA"));//["AAAAAAAAAA"]
    }

}
