package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class XofaKindinaDeckofCards {
//	 public boolean hasGroupsSizeX(int[] deck) {
//	      if(deck.length<2) {
//	    	  return false;
//	      }
//	      Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//	      for(int i=0;i<deck.length;i++) {
//	    	if(map.containsKey(deck[i])) {
//	    		map.put(deck[i], map.get(deck[i])+1);
//	    	}else {
//	    		map.put(deck[i], 1);
//	    	}
//	      }	      
//	      Set<Integer> s = new HashSet<Integer>(map.values()); 
//	      List<Integer> li = new ArrayList<Integer>(s);
//	      int frist = li.get(0);
//	      for(int i=1;i<li.size();i++) {
//	    	  frist=getGreatestCommonDivisor(frist,li.get(i));
//	      }
//	      if(frist>=2) {
//	    	  return true;
//	      }
//	      return false;
//	 }
//	 
//	 int getGreatestCommonDivisor(int a, int b) {
//		 if(a==b) {
//			return a;
//		 }else if(a<b) {
//			 int temp = a;
//			 a = b;
//			 b = temp;
//		 }
//		 while(b>0 && a%b!=0) {
//			 int c=a%b;
//			 a = b;
//			 b = c;
//		 }
//		 return b;
//	 }


    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c : deck)
            count[c]++;

        List<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0)
                values.add(count[i]);

        search:
        for (int X = 2; X <= N; ++X)
            if (N % X == 0) {
                for (int v : values)
                    if (v % X != 0)
                        continue search;
                return true;
            }

        return false;
    }

    public static void main(String[] args) {
        XofaKindinaDeckofCards xf = new XofaKindinaDeckofCards();
        System.out.println(xf.hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
        // System.out.println(xf.getGreatestCommonDivisor(377,319));
    }
}
