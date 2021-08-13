package test;

/**
 * @author LeiDongxing
 * created on 2021/6/29
 * Excel表列名称
 */
public class ExcelSheetColumnTitle {
    //A -> 1
    //B -> 2
    //C -> 3
    //...
    //Z -> 26
    //AA -> 27
    //AB -> 28
    //...
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int tmp = (columnNumber - 1) % 26 + 1;
            sb.append((char) (tmp + 'A' - 1));
            columnNumber = (columnNumber - tmp) / 26;
        }
        return sb.reverse().toString();
    }

    //A -> 1
    //B -> 2
    //C -> 3
    //...
    //Z -> 26
    //AA -> 27
    //AB -> 28
    //    ...
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int num = (columnTitle.charAt(i) - 'A' + 1);
            result = result * 26 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
        System.out.println(esct.convertToTitle(1));//A 26*0+1
        System.out.println(esct.convertToTitle(28));//AB  26*1+2
        System.out.println(esct.convertToTitle(701));//ZY  26*26+25
        System.out.println(esct.convertToTitle(2147483647));//FXSHRXW  26^1+2
    }
}
