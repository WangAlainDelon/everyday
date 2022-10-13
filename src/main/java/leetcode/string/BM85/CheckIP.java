package leetcode.string.BM85;

public class CheckIP {
    /**
     * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址
     * <p>
     * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
     * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
     **/


    public static void main(String[] args) {
        String str = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String solve = solve(str);
    }

    public static String solve(String IP) {
        if (checkIpV4(IP)) {
            return "IPv4";
        } else if (checkIpV6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private static boolean checkIpV4(String str) {
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }

        String regx = "^[0-9]+$";
        for (int i = 0; i < split.length; i++) {
            if (split.length != 1 && split[i].startsWith("0")) {
                return false;
            }
            boolean matches = split[i].matches(regx);
            if (!matches) {
                return false;
            }
            if (Integer.parseInt(split[i]) <= 0 || Integer.parseInt(split[i]) >= 255) {
                return false;
            }

        }
        return true;
    }

    private static boolean checkIpV6(String str) {
        if (str.endsWith(":")){
            return false;
        }
        //2001:db8:85a3:0:0:8A2E:0370:7334
        String regex="^[A-Fa-f0-9]+$";
        String[] split = str.split(":");
        if (split.length != 8) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("")) {
                return false;
            }
            //16进制   //不能出现a-fA-F以外的大小写字符
            if (!split[i].matches(regex)){
                return false;
            }

        }
        return true;
    }


}
