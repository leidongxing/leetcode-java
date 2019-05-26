package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int sum = 0;
        int times = k;
        int max = 9;
        int min = 0;
        if ((19 - k) * k / 2 < n) {
            return result;
        } else if ((1 + k) * k / 2 > n) {
            return result;
        } else {
            while (times > 0) {
                times--;

            }
        }


        while (max > k) {
            List<Integer> al = new ArrayList<Integer>();
            for (int i = max; times > 0; i--) {
                sum += i;
                al.add(i);
                times--;
            }
            if (sum == n) {
                result.add(al);

            } else if (sum < n) {
                break;
            }
            max--;
            sum = 0;
            times = k;
        }
        return result;
    }

    int findX(int num) {
        return num;
    }


    public static void main(String[] args) {
        //CombinationSumIII cs = new CombinationSumIII();
        //System.out.println(cs.combinationSum3(3, 7));
        File f = new File("D:\\opencv2X\\build\\x86\\vc14\\lib");
        File[] fs = f.listFiles();
        for (int i = 0; i < fs.length; i++) {
            if (fs[i].getName().charAt((int) (fs[i].getName().length() - 5)) == 'd') {
                System.out.println(fs[i].getName());
            }
        }


    }
}
