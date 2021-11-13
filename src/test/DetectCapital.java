package test;

/**
 * 检测大写字母
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        // 若第1个字母为小写，则需额外判断第2个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        // 无论第1个字母是否大写，其他字母必须与第2个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }


    public boolean detectCapitalUse1(String word) {
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
	 
	 
