package test;

/**
 * @author LeiDongxing
 * created on 2021/10/4
 * 密钥格式化
 */
public class LicenseKeyFormatting {
    /**
     * @param s 密钥字符串只包含字母，数字以及 '-'（破折号） N 个 '-' 将字符串分成了 N+1 组
     * @param k 重新格式化字符串，使每个分组恰好包含K个字符 特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int currentK = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                continue;
            }
            sb.append(Character.toUpperCase(s.charAt(i)));
            currentK++;
            if (currentK == k) {
                currentK = 0;
                sb.append("-");
            }
        }
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == '-') {
//            sb.deleteCharAt(length - 1);
            sb.replace(length - 1, length, "");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4)); //5F3Z-2E9W
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J", 2)); //2-5G-3J
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("--a-a-a-a--", 2)); //AA-AA
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("---", 3));
    }
}
