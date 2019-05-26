package test;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistancetoaCharacter {

//    public int[] shortestToChar(String S, char C) {
//        int[] result = new int[S.length()];
//        char[] sChar = S.toCharArray();
//        Queue<Integer> list = new LinkedList<Integer>();  
//        int last=0;
//        int undone=0;
//        int now=0;        
//        for(int i=0;i<sChar.length;i++) {
//        	if(sChar[i]==C) {
//        		result[i]=0;
//        		if(!list.isEmpty()) {
//        			last=list.poll();
//        		}
//        		for(int j=undone;j<i;j++) {
//        			now = Math.abs(i-j);
//        			if(result[j]==-1) {
//        				result[j] =now;
//        				undone++;
//        			}else {
//        				result[j]=Math.min(result[j], now);
//        			}
//        		}
//        		list.add(i);
//        	}else {
//        		if(list.isEmpty()) {
//        			now = -1;
//        		}else {
//        			last=list.peek();
//        			now = Math.abs(i-last);
//        		}
//    			result[i]=now;        		
//        	}
//        }
//    	return result;
//    }


    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N - 1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        ShortestDistancetoaCharacter s = new ShortestDistancetoaCharacter();
        s.shortestToChar("loveleetcod", 'e');
    }
}
