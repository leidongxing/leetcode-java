package test;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> sumSet = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            String[] email = emails[i].split("@");
            StringBuilder s = new StringBuilder();
            for (char c : email[0].toCharArray()) {
                if (c == '.') {
                    continue;
                } else if (c == '+') {
                    break;
                } else {
                    s.append(c);
                }
            }
            s.append(email[1]);
            sumSet.add(s.toString());
        }
        return sumSet.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddresses u = new UniqueEmailAddresses();
        System.out.println(u.numUniqueEmails(new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
