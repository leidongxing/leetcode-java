package test;

public class ClacTimeThread extends Thread {
    private Solution s;

    ClacTimeThread(Solution s) {
        this.s = s;
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        s.doIt();
        System.out.println("run  time: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
