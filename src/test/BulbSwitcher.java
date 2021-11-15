package test;

/**
 * @author LeiDongxing
 * created on 2021/11/15
 * 灯泡开关
 */
public class BulbSwitcher {
    /**
     * @param n 个灯泡
     * @return n轮后亮着的灯泡
     */
    public int bulbSwitch(int n) {
        //对于第x个灯泡，它经过n轮，什么情况下它还亮着呢？只有对x做了奇数次的切换才能保证x是亮着的。
        //什么情况下会切换第x个灯泡的开关  当轮数k是x的约数时才会切换第x个灯泡的开关
        //约数为奇数个   完全平方数的约数是奇数个  非完全平方数的约数都是偶数个
        return (int) Math.sqrt(n + 0.5);
    }

    public static void main(String[] args) {
        BulbSwitcher bs = new BulbSwitcher();
        System.out.println(bs.bulbSwitch(3));//1
        System.out.println(bs.bulbSwitch(0));//1
        System.out.println(bs.bulbSwitch(1));//1
    }
}
