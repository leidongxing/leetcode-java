package test;

/**
 * @author LeiDongxing
 * created on 2022/5/29
 * 验证IP地址
 */
public class ValidateIPAddress {

    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            int last = -1;
            for (int i = 0; i < 4; i++) {
                int cur = (i == 3 ? queryIP.length() : queryIP.indexOf(".", last + 1));
                if (cur < 0) {
                    return "Neither";
                }
                if (cur - last - 1 < 1 || cur - last - 1 > 3) {
                    return "Neither";
                }
                int addr = 0;
                for (int j = last + 1; j < cur; j++) {
                    if (!Character.isDigit(queryIP.charAt(j))) {
                        return "Neither";
                    }
                    addr = addr * 10 + (queryIP.charAt(j) - '0');
                }
                if (addr > 255) {
                    return "Neither";
                }
                if (addr > 0 && queryIP.charAt(last + 1) == '0') {
                    return "Neither";
                }
                if (addr == 0 && cur - last - 1 > 1) {
                    return "Neither";
                }
                last = cur;
            }
            return "IPv4";
        } else {
            int last = -1;
            for (int i = 0; i < 8; i++) {
                int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(":", last + 1));
                if (cur < 0) {
                    return "Neither";
                }
                if (cur - last - 1 < 1 || cur - last - 1 > 4) {
                    return "Neither";
                }
                for (int j = last + 1; j < cur; ++j) {
                    if (!Character.isDigit(queryIP.charAt(j)) && !('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f')) {
                        return "Neither";
                    }
                }
                last = cur;
            }
            return "IPv6";
        }
    }


    public static void main(String[] args) {
        ValidateIPAddress v = new ValidateIPAddress();
        System.out.println(v.validIPAddress("172.16.254.1"));//IPv4
        System.out.println(v.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));//IPv6
        System.out.println(v.validIPAddress("256.256.256.256"));//Neither
    }
}
