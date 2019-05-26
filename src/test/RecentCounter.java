package test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecentCounter {
    //List<Integer> list;
    Queue<Integer> q;

    public RecentCounter() {
        //list =new LinkedList<Integer>();
        q = new LinkedList<Integer>();
    }

    public int ping(int t) {
//        int sum=0;
//        Iterator<Integer> it =list.iterator();
//      
//        while(it.hasNext()) {
//        	int i=it.next();
//        	if(i>=t-3000) {
//        		sum++;
//        	}else {
//        		it.remove();
//        	}
//        }
//        return sum;
        q.add(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();


    }

    public static void main(String[] args) {
        RecentCounter a = new RecentCounter();
        System.out.println(a.ping(1));
        System.out.println(a.ping(100));
        System.out.println(a.ping(3001));
        System.out.println(a.ping(3002));
    }
}
