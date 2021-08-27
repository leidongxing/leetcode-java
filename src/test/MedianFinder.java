package test;

import java.util.PriorityQueue;

/**
 * @author LeiDongxing
 * created on 2021/8/27
 * 数据流的中位数
 */
public class MedianFinder {
    PriorityQueue<Integer> queueMin;
    PriorityQueue<Integer> queueMax;

    public MedianFinder() {
        //小于等于中位数的数
        queueMin = new PriorityQueue<>((a, b) -> (b - a));
        //大于中位数的数
        queueMax = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (queueMin.isEmpty() || num <= queueMin.peek()) {
            queueMin.offer(num);
            if (queueMax.size() + 1 < queueMin.size()) {
                queueMax.offer(queueMin.poll());
            }
        } else {
            queueMax.offer(num);
            if (queueMax.size() > queueMin.size()) {
                queueMin.offer(queueMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queueMin.size() > queueMax.size()) {
            return queueMin.peek();
        }
        return (queueMin.peek() + queueMax.peek()) / 2.0d;
    }


    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());//1.5
        mf.addNum(3);
        System.out.println(mf.findMedian());//2
    }
}
