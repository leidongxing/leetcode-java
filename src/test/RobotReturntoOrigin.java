package test;

public class RobotReturntoOrigin {
    public boolean judgeCircle(String moves) {
        int xas = 0;
        int yas = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                yas++;
            } else if (c == 'D') {
                yas--;
            } else if (c == 'R') {
                xas++;
            } else {
                xas--;
            }
        }
        return xas == 0 && yas == 0;
    }

    public static void main(String[] args) {
        RobotReturntoOrigin r = new RobotReturntoOrigin();
        System.out.println(r.judgeCircle("LL"));
    }
}
