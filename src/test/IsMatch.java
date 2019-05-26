package test;

import java.util.regex.Pattern;

public class IsMatch implements Solution {
    public boolean isMatch(String s, String p) {

        return Pattern.matches(p, s);
    }

    @Override
    public void doIt() {
        System.out.println(this.isMatch("aa", "a"));  //false
        System.out.println(this.isMatch("aa", "aa")); // true
        System.out.println(this.isMatch("aaa", "aa")); //false
        System.out.println(this.isMatch("aa", "a*")); //true
        System.out.println(this.isMatch("aa", ".*")); //true
        System.out.println(this.isMatch("ab", ".*")); //true
        System.out.println(this.isMatch("aab", "c*a*b")); //true
        System.out.println(this.isMatch("aa", "a"));
    }

    public static void main(String[] args) {
        IsMatch i = new IsMatch();
        new ClacTimeThread(i).run();
    }
}
