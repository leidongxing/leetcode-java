package algorithm;

public class JosephProblem {
    public int method1(int n, int m){
        if(n==2){
            return (m%2)==0 ?2:1;
        }
        int v=(m+method1(n-1,m))%n;
        if(v==0){
            v=n;
        }
        return v;
    }

    public static void main(String[] args){
        JosephProblem jp = new JosephProblem();
        System.out.println(jp.method1(1,50));
    }



}
