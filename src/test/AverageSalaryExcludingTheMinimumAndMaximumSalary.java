package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/1/31
 * 去掉最低工资和最高工资后的工资平均值
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int sum = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return (double) sum / (salary.length - 2);
    }
}
