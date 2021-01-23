package test;

/**
 * @author LeiDongxing
 * created on 2021/1/23
 * 按序打印
 */
public class PrintInOrder {
    /**
     * 确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行
     */
    private static class Foo {
        public Foo() {

        }

        public void first() {
            System.out.print("first");
        }

        public void second() {
            System.out.print("second");
        }

        public void third() {
            System.out.print("third");
        }

        private final Object o = new Object();
        private boolean firstFinished;
        private boolean secondFinished;

        public void first(Runnable printFirst) throws InterruptedException {
            first();
            synchronized (o) {
                firstFinished = true;
                o.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (o) {
                while (!firstFinished) {
                    o.wait();
                }
                second();
                secondFinished = true;
                o.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (o) {
                while (!secondFinished) {
                    o.wait();
                }
                third();
            }
        }
    }


    private static class AThread extends Thread {
        private final Foo foo;

        AThread(Foo foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            try {
                foo.first(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class BThread extends Thread {
        private final Foo foo;

        BThread(Foo foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            try {
                foo.second(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class CThread extends Thread {
        private final Foo foo;

        CThread(Foo foo) {
            this.foo = foo;
        }

        @Override
        public void run() {
            try {
                foo.third(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        AThread a = new AThread(foo);
        BThread b = new BThread(foo);
        CThread c = new CThread(foo);
        a.start();
        b.start();
        c.start();
    }
}
