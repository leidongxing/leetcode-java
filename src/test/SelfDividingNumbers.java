package test;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
//        List<Integer> result= new ArrayList<Integer>();
//        for(int i=left;i<=right;i++) {
//        	StringBuilder s = new StringBuilder();
//        	s.append(i);
//        	boolean isOk=true;
//            for(int j=0;j<s.toString().length();j++) {
//            	String d = String.valueOf(s.charAt(j));
//            	if(d.equals("0")) {
//            		isOk=false;
//            		break;
//            	}else {
//            		if(i% Integer.parseInt(String.valueOf(s.charAt(j)))!=0){
//                		isOk=false;
//                		break;
//                	}
//            	}
//            }
//            if(isOk) {
//            	result.add(i);
//            }       	
//        }
//		   return result;


        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if ((j % 10 == 0) || (i % (j % 10) != 0)) break;
            }
            if (j == 0) list.add(i);
        }
        return list;

    }


    public static void main(String[] args) {
        SelfDividingNumbers r = new SelfDividingNumbers();
        r.selfDividingNumbers(1, 22);
    }
}
