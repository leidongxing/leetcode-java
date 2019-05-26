package test;

import java.util.Stack;

public class NumberComplement {
    //	public int findComplement(int num) {
//       Stack<Integer> s = new Stack<Integer>();
//	   while(num/2!=0) {
//    	   if(num%2==0) {
//    		   s.push(1);
//    	   }else {
//    		   s.push(0);
//    	   }
//    	   num=num/2;
//       }
//	   if(num%2==0) {
//		   s.push(1);
//	   }else {
//		   s.push(0);
//	   }
//	   System.out.println(s);
//       int sum=0;
//       int cap=s.size();
//	   for(int i=0;i<cap;i++) {
//		   if(s.peek()==1) {
//			   sum+=Math.pow(2, cap-1-i);
//		   }
//		   s.pop();
//	   }
//	   return sum;
//	}
//	
    public int findComplement(int num) {
        int mask = ~0;
        System.out.println(mask);
        while ((num & mask) != 0) {
            mask <<= 1;
        }
        return ~mask & ~num;
    }

    public static void main(String[] args) {
        NumberComplement n = new NumberComplement();
        System.out.println(n.findComplement(1));
    }
}
