package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2022/5/31
 * 火星词典
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }
        //保存所有的尝试结果
        List<String> result = new ArrayList<>();

        return result.isEmpty() ? "" : result.get(0);
    }
}
