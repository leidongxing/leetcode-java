package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/6/21
 * 二进制手表
 */
public class BinaryWatch {
    /**
     * @param turnedOn 表示当前亮着的 LED 的数量
     * @return 返回二进制手表可以表示的所有可能时间
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                //枚举小时的所有可能值 [0,11][0,11]，以及分钟的所有可能值 [0,59][0,59]，并计算二者的二进制中 11 的个数之和，若为turnedOn，则将其加入到答案中
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return result;
    }
}
