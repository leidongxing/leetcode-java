package test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class NumbersWithSameConsecutiveDifferences {
//	public int[] numsSameConsecDiff(int N, int K) {
//		Set<Integer> set = new TreeSet<Integer>();
//		for(int i=0;i<=9;i++) {
//			if(i-K>=0) { 
//				int sum =0;
//				int times=0;
//				   for(int j=N-1;j>=0;j--) {
//					   int x=i;
//					   if(times%2==1) {
//						   x=i-K;
//					   }
//					   times++;
//					   sum+=x*(int) Math.pow(10, j);
//				   }
//				   set.add(sum);     
//			}
//			
//			if(i+K<=9) {
//			   boolean isOk =true;
//			   int sum =0;
//			   int times=0;
//			   for(int j=N-1;j>=0;j--) {
//				   int x=i;
//				   if(times%2==1) {
//					   x=i+K;
//				   }
//				   if(x==0 && times==0 && N>1) {
//					   isOk=false;
//				   }
//				   times++;
//				   sum+=x*(int) Math.pow(10, j);
//			   }
//			   set.add(sum);  
//			   if(isOk==false) {
//				   set.remove(sum);
//				   isOk=true;
//			   }
//			}
//			
//		}
//		Integer[] IArray = new Integer[] {};
//	    IArray =(Integer[])set.toArray(IArray);
//	    System.out.println(set);
//		int[] result =new int[IArray.length];
//		for(int i=0;i<result.length;i++) {
//			result[i]=IArray[i];
//		}
//	    return result;
//	}

    public int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> cur = new HashSet();
        for (int i = 1; i <= 9; ++i)
            cur.add(i);

        for (int steps = 1; steps <= N - 1; ++steps) {
            Set<Integer> cur2 = new HashSet();
            for (int x : cur) {
                int d = x % 10;
                if (d - K >= 0)
                    cur2.add(10 * x + (d - K));
                if (d + K <= 9)
                    cur2.add(10 * x + (d + K));
            }

            cur = cur2;
        }

        if (N == 1)
            cur.add(0);

        int[] ans = new int[cur.size()];
        int t = 0;
        for (int x : cur)
            ans[t++] = x;
        return ans;
    }


    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences n = new NumbersWithSameConsecutiveDifferences();
        n.numsSameConsecDiff(1, 6);
    }
}
