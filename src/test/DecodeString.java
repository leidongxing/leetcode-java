package test;

import java.util.Stack;

/**
 * @author LeiDongxing
 * created on 2020/5/28
 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder result=new StringBuilder();
        Stack<Integer> digitStack=new Stack<>();
        Stack<StringBuilder> stringStack=new Stack<>();
        int multi=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                multi=multi*10+c-'0';
            }
            else if(c=='['){
                stringStack.add(result);
                digitStack.add(multi);
                result=new StringBuilder();
                multi=0;
            }else if(Character.isAlphabetic(c)){
                result.append(c);
            }else{
                StringBuilder resultTmp=stringStack.pop();
                int tmp=digitStack.pop();
                for(int i=0;i<tmp;i++){
                    resultTmp.append(result);
                }
                result=resultTmp;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[a]2[bc]"));
        System.out.println(ds.decodeString("3[a2[c]]"));
        System.out.println(ds.decodeString("2[abc]3[cd]ef"));

    }
}
