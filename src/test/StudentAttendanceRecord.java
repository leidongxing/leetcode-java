package test;

/**
 * @author LeiDongxing
 * created on 2021/2/6
 * 学生出勤记录
 */
public class StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        int preL = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                if (preL == i - 1 && l == 2) {
                    return false;
                } else {
                    preL = i;
                    l++;
                }
            } else {
                if (l != 0) {
                    l = 0;
                    preL = 0;
                }
                if (c == 'A') {
                    a++;
                    if (a > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
