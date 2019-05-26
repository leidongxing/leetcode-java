package algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class PartOneChapterTwo {
    public void daffodil() {
        for (int i = 100; i <= 999; i++) {
            int a = i / 100;
            int b = (i % 100) / 10;
            int c = (i % 100) % 10;
            if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == i) {
                System.out.println(i);
            }
        }
    }


    public void hanxin() {
        File file = new File("C:\\Users\\Administrator\\Desktop\\demo.txt");
        StringBuilder output = new StringBuilder();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String lineBuffer = null;
            while ((lineBuffer = br.readLine()) != null) {
                int a = Integer.valueOf(lineBuffer.split(" ")[0]);
                int b = Integer.valueOf(lineBuffer.split(" ")[1]);
                int c = Integer.valueOf(lineBuffer.split(" ")[2]);
                int i = 10;
                while (i <= 100) {
                    if (i % 3 == a && i % 5 == b && i % 7 == c) {
                        output.append(i).append("\r\n");
                        break;
                    }
                    i++;
                    if (i > 100) {
                        output.append("NO ANSWER").append("\r\n");
                    }
                }
            }
            br.close();

            File out = new File("C:\\Users\\Administrator\\Desktop\\out.txt");
            FileOutputStream fo = new FileOutputStream(out);
            fo.write(output.toString().getBytes("UTF-8"));
            fo.flush();
            fo.close();
            System.out.println(output);

//            FileInputStream  fi = new FileInputStream(file);
//            byte[] buffer = new byte[3];
//            while(fi.read(buffer)!=-1){
//            	String test =new String(buffer);
//            	System.out.println(test);
//            }
//    		fi.close();   
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void triangle() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = n; i > 0; i--) {
            if (i != n) {
                for (int k = 0; k < n - i; k++) {
                    System.out.print(" ");
                }
            }
            for (int j = 2 * i - 1; j > 0; j--) {

                System.out.print("*");
            }
            System.out.print("\r\n");
        }
    }

    public void subsequence() {
        Scanner s = new Scanner(System.in);
        double n = s.nextDouble();
        double m = s.nextDouble();
        double result = 0d;
        for (; n < m; n++) {
            result += 1 / n / n;
        }
        result += 1 / m / m;

        System.out.println(result);
    }

    public void decimal() {
        Scanner s = new Scanner(System.in);
        double a = s.nextDouble();
        double b = s.nextDouble();
        int times = s.nextInt();
        double r = a / b;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(times);
        String temp = nf.format(r);
        System.out.println(temp);
    }

    public void permutation() {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                for (int k = 100; k < 1000; k++) {
                    if (j == 2 * i && k == 3 * i) {
                        set.add(i / 100);
                        set.add((i % 100) / 10);
                        set.add((i % 100) % 10);

                        set.add(j / 100);
                        set.add((j % 100) / 10);
                        set.add((j % 100) % 10);

                        set.add(k / 100);
                        set.add((k % 100) / 10);
                        set.add((k % 100) % 10);

                        if (set.size() == 9) {
                            System.out.println(i + " " + j + " " + k);
                        }
                        set.clear();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PartOneChapterTwo p = new PartOneChapterTwo();
        p.permutation();
        double i;
        for (i = 0; i != 10; i += 0.1) {
            System.out.println(i);
        }


    }
}
