package test;

import java.util.Iterator;

/**
 * @author LeiDongxing
 * created on 2021/10/5
 * 窥探迭代器
 */
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        // 使用指定整数数组nums初始化迭代器
        this.iterator = iterator;
        nextElement = iterator.next();
    }

    // 返回数组中的下一个元素，但 不 移动指针。
    public Integer peek() {
        return nextElement;
    }


    // 返回数组中的下一个元素，并将指针移动到下个元素处
    @Override
    public Integer next() {
        Integer ret = nextElement;
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return ret;
    }

    // 如果数组中存在下一个元素，返回 true ；否则，返回 false
    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}
