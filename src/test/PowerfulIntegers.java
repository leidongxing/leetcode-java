package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {
    //1<=x<=100 1<=y<=100
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<Integer>();
        int j = 0;
        int i = 0;
        int iSum = (int) Math.pow(x, i);
        while (iSum <= bound) {
            int jSum = (int) Math.pow(y, j);
            while (iSum + jSum <= bound) {
                set.add(iSum + jSum);
                if (y == 1) {
                    break;
                }
                j++;
                jSum = (int) Math.pow(y, j);
            }
            if (x == 1) {
                break;
            }
            j = 0;
            i++;
            iSum = (int) Math.pow(x, i);
        }
        List<Integer> result = new ArrayList<Integer>(set);
        return result;
    }

    int getBaseLog(int x, int y) {  //log x y
        return (int) (Math.log(y) / Math.log(x));
    }

    public static void main(String[] args) {
        PowerfulIntegers p = new PowerfulIntegers();
        System.out.println(p.powerfulIntegers(1, 1, 2));
    }
}
