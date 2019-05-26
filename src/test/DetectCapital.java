package test;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] sChar = word.toCharArray();
        boolean isAllUp = false;
        boolean isAllLow = false;
        if (sChar.length == 1) {
            return true;
        } else if (sChar[0] >= 'A' && sChar[0] <= 'Z' && sChar[1] >= 'A' && sChar[1] <= 'Z') {
            isAllUp = true;
        } else if (sChar[0] >= 'a' && sChar[0] <= 'z' && sChar[1] >= 'a' && sChar[1] <= 'z') {
            isAllLow = true;
        }

        if (isAllUp) {
            for (int i = 1; i < sChar.length; i++) {
                if (sChar[i] < 'A' || sChar[i] > 'Z') {
                    return false;
                }
            }
        } else if (isAllLow) {
            for (int i = 1; i < sChar.length; i++) {
                if (sChar[i] < 'a' || sChar[i] > 'z') {
                    return false;
                }
            }
        } else {
            if (sChar[0] < 'A' || sChar[0] > 'Z') {
                return false;
            }
            for (int i = 1; i < sChar.length; i++) {
                if (sChar[i] >= 'A' && sChar[i] <= 'Z') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DetectCapital d = new DetectCapital();
        System.out.println(d.detectCapitalUse("ggg"));
    }
}
	 
	 
