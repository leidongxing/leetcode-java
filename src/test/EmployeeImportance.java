package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/5/1
 * 员工的重要性
 */
public class EmployeeImportance {
    class Employee {
        //唯一的 id
        public int id;
        //重要度
        public int importance;
        //直系下属的id
        public List<Integer> subordinates;
    }

    //返回这个员工和他所有下属的重要度之和
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> id2Employees = new HashMap<>();
        for (Employee employee : employees) {
            id2Employees.put(employee.id, employee);
        }
        return get(id2Employees, id);
    }

    private int get(Map<Integer, Employee> id2Employees, int id) {
        int sum = id2Employees.get(id).importance;
        for (Integer subId : id2Employees.get(id).subordinates) {
            sum += get(id2Employees, subId);
        }
        return sum;
    }
}
