package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PartOneChapterOne {

    public double average() {
        double sum = 0d;
        int time = 0;
        Scanner s = new Scanner(System.in);
        while (s.hasNextDouble()) {
            sum += s.nextDouble();
            time++;
        }
        return sum / time;
    }

    public double temperature() {
        Scanner s = new Scanner(System.in);
        if (s.hasNextDouble()) {
            return (s.nextDouble() - 32) * 5 / 9;
        }
        return -1d;
    }

    public int sum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public String sinandcos(double d) {
        return "sin " + Math.sin(d) + " cos " + Math.cos(d);

    }

    public double discount(int n) {
        if (n * 95 < 300) {
            return n * 95;
        } else {
            return n * 95 * 0.85;
        }
    }

    public String triangle() {
        Scanner s = new Scanner(System.in);
        List<Double> list = new ArrayList<Double>();
        while (s.hasNextDouble()) {
            list.add(s.nextDouble());
        }
        if (list.size() != 3) {
            return "not a triangle";
        }
        Collections.sort(list, new Comparator<Double>() {
            @Override
            public int compare(Double paramT1, Double paramT2) {
                return paramT1 > paramT2 ? -1 : 1;
            }
        });
        if (list.get(0) >= list.get(1) + list.get(2)) {
            return "not a triangle";
        } else if (Math.pow(list.get(0), 2) == Math.pow(list.get(1), 2)
                + Math.pow(list.get(2), 2)) {
            return "yes";
        } else {
            return "no";
        }
    }

    public void year() {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int i = s.nextInt();
            if ((i % 100 == 0 && i % 400 == 0)
                    || (i % 100 != 0 && i % 4 == 0)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static void main(String[] args) {
        PartOneChapterOne p = new PartOneChapterOne();
        p.year();

    }
}
