package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/10/3
 * 分数到小数
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        //能够整除
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }
        //整数部分

        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long interPart = numeratorLong / denominatorLong;
        sb.append(interPart);
        sb.append(".");

        //小数部分
        StringBuilder fractionPart = new StringBuilder();
        Map<Long, Integer> remainedIndexMap = new HashMap<>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;
        while (remainder != 0 && !remainedIndexMap.containsKey(remainder)) {
            remainedIndexMap.put(remainder, index);
            remainder *= 10;
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index++;
        }
        //存在循环节
        if (remainder != 0) {
            int insertIndex = remainedIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');
            fractionPart.append(")");
        }
        sb.append(fractionPart);
        return sb.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal f = new FractionToRecurringDecimal();
        System.out.println(f.fractionToDecimal(1, 2));//"0.5"
        System.out.println(f.fractionToDecimal(2, 1));//"2"
        System.out.println(f.fractionToDecimal(2, 3));//"0.(6)"
        System.out.println(f.fractionToDecimal(4, 333));//"0.(012)"
        System.out.println(f.fractionToDecimal(1, 5));//"0.2"
    }
}
