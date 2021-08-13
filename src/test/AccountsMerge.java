package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/1/18
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind[] array = new UnionFind[accounts.size()];
        array[0] = new UnionFind(accounts.get(0));

        for (int i = 1; i < accounts.size(); i++) {
            UnionFind tmp = new UnionFind(accounts.get(i));
            for (int j = 0; j < array.length; j++) {
                if (array[j] != null && array[j].find(tmp)) {
                    array[j].merge(tmp);
                    array[i] = null;
                } else {
                    array[i] = tmp;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (UnionFind f : array) {
            if (f != null) {
                List<String> tmp = new ArrayList<>();
                tmp.add(f.name);
                tmp.addAll(f.emails);
                result.add(tmp);
            }
        }
        return result;
    }

    private class UnionFind {
        private String name;
        private Set<String> emails;

        public UnionFind(List<String> accounts) {
            name = accounts.get(0);
            emails = new HashSet<>();
            for (int i = 1; i < accounts.size(); i++) {
                emails.add(accounts.get(i));
            }
        }

        public boolean find(UnionFind f) {
            Set<String> s1 = new HashSet<>(this.emails);
            Set<String> s2 = new HashSet<>(f.emails);
            s1.retainAll(s2);
            return s1.isEmpty();
        }

        public UnionFind merge(UnionFind f2) {
            this.emails.addAll(f2.emails);
            return this;
        }
    }

    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();
        List<String> list1 = new ArrayList<>();
        list1.add("John");
        list1.add("johnsmith@mail.com");
        list1.add("john00@mail.com");

        List<String> list2 = new ArrayList<>();
        list2.add("John");
        list2.add("johnnybravo@mail.com");

        List<String> list3 = new ArrayList<>();
        list3.add("John");
        list3.add("johnsmith@mail.com");
        list3.add("john_newyork@mail.com");

        List<String> list4 = new ArrayList<>();
        list4.add("Mary");
        list4.add("mary@mail.com");

        List<List<String>> al = new ArrayList<>();
        al.add(list1);
        al.add(list2);
        al.add(list3);
        al.add(list4);
        System.out.println(accountsMerge.accountsMerge(al));
    }
}
