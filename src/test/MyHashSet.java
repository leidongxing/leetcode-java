package test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author LeiDongxing
 * created on 2021/3/13
 * 设计哈希集合
 */
public class MyHashSet {
    private static final int BASE = 769;
    private LinkedList<Integer>[] data;

    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element.equals(key)) {
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element.equals(key)) {
                data[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element.equals(key)) {
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key % BASE;
    }
}
