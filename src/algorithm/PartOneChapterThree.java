package algorithm;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PartOneChapterThree {
    public void kaideng(int n, int k) {
        boolean[] deng = new boolean[n];
        for (int i = 0; i < n; i++) {
            deng[i] = true;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if ((j + 1) % i == 0) {
                    if (deng[j] == true) {
                        deng[j] = false;
                    } else {
                        deng[j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (deng[i] == true) {
                System.out.println(i + 1);
            }
        }
    }

    public void Score(String s) {
        int nums = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'O') {
                nums++;
                sum += nums;
            } else {
                nums = 0;
            }
            System.out.print(nums + "+");
        }
        System.out.println(sum);
    }

    public void MolarMass(String s) {
        Map<Character, Double> map = new HashMap<Character, Double>();
        map.put('C', 12.01);
        map.put('H', 1.008);
        map.put('O', 16.00);
        map.put('N', 14.01);

        char prev = ' ';
        double sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char e = s.charAt(i);
            if (e > '9' || e < '0') {
                if (prev != ' ') {
                    sum += map.get(prev);
                }
                prev = e;
            } else {
                double a = map.get(prev);
                int b = Integer.parseInt(String.valueOf(e));
                sum += a * b;
                prev = ' ';
            }
        }
        if (prev != ' ') {
            sum += map.get(prev);
        }
        System.out.println(sum);

    }

    public void PeriodicStrings(String s) {
        List<Character> al = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!al.isEmpty() && s.charAt(i) == al.get(0)) {
                int j = i + 1;
                for (int k = 1; j < al.size(); j++) {
                    if (s.charAt(j) != al.get(k)) {
                        break;
                    }
                    k++;
                }
                break;
            }
            al.add(s.charAt(i));
        }
        for (char c : al) {
            System.out.print(c);
        }
    }

    public void puzzle() {
        Map<Integer, String> xy2char = new HashMap<Integer, String>();
        xy2char.put(11, "T");
        xy2char.put(21, "R");
        xy2char.put(31, "G");
        xy2char.put(41, "S");
        xy2char.put(51, "J");
        xy2char.put(12, "X");
        xy2char.put(22, "D");
        xy2char.put(32, "O");
        xy2char.put(42, "K");
        xy2char.put(52, "I");
        xy2char.put(13, "M");

        xy2char.put(33, "V");
        xy2char.put(43, "L");
        xy2char.put(53, "N");
        xy2char.put(14, "W");
        xy2char.put(24, "P");
        xy2char.put(34, "A");
        xy2char.put(44, "B");
        xy2char.put(54, "E");
        xy2char.put(15, "U");
        xy2char.put(25, "Q");
        xy2char.put(35, "H");
        xy2char.put(45, "C");
        xy2char.put(55, "F");
        int in = 23;

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String c = s.next();
            int target = -1;
            if ("0".equals(c)) {
                break;
            } else if ("A".equals(c)) {
                target = in - 1;
            } else if ("B".equals(c)) {
                target = in + 1;
            } else if ("L".equals(c)) {
                target = in - 10;
            } else if ("R".equals(c)) {
                target = in + 10;
            }

            if (target < 11 || target > 55) {
                System.out.println("This puzzle has no final configuration.");
            }
            String r = xy2char.remove(target);
            xy2char.put(in, r);
            in = target;
        }
        int i = 11, j = 11;
        while (j <= 15) {
            if (xy2char.get(i) == null) {
                System.out.print("  ");
            } else {
                System.out.print(xy2char.get(i) + " ");
            }
            i += 10;
            if (i / 10 > 5) {
                System.out.println();
                j++;
                i = j;
            }
        }
    }

    public void crosswordAnswers() {
        Scanner s = new Scanner(System.in);
        int height = 0;
        int weight = 0;
        while (s.hasNext()) {
            String c = s.next();
            System.out.println(c);


            if (c.equals("0")) {
                break;
            }
        }
        System.out.println(height + " " + weight);
    }

    public void DNAConsensusString() {
        Scanner s = new Scanner(System.in);

    }

    public void repeatingDecimals() {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = a % b;

        StringBuilder sb = new StringBuilder();
        while (true) {
            int current = c * 10 / b;
            if (sb.substring(0).equals(String.valueOf(current))) {
                break;
            }
            sb.append(c * 10 / b);
            c = current * 10 % b;
        }
        System.out.println(sb);
    }

    public boolean allinall(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return false;
        }
        for (int i = 0, j = 0; i < s2.length(); i++) {
            while (s1.charAt(j) != s2.charAt(i)) {
                j++;
                if (j >= s1.length()) {
                    return false;
                }
            }
        }
        return true;
    }


    public int fn(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fn(n - 1);
    }

    public boolean box(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        if (map.size() == 1 || map.size() == 3) {
            return true;
        }
        return false;
    }

    public void floatingPointNumbers() {

    }

    public static void main(String[] args) {
        PartOneChapterThree p = new PartOneChapterThree();
//		p.Score("OOXXOXXOOO");
//		p.MolarMass("C6H5OH");
//		p.PeriodicStrings("abcabcabcabc");
//		int a = 0;
//		System.out.println(++a + ++a + ++a);
//		System.out.println(a++ + a++ + a++); 
//		p.puzzle();
//		p.crosswordAnswers();
//		p.repeatingDecimals();   
//		System.out.println(new PartOneChapterThree().fn(100));
        System.out.println(p.allinall("abcde", "bce"));
    }
}
