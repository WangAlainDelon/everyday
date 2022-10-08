package leetcode.zhaoyinwangluo;

public class MagicString {


    //一个字符串是否能由cm通过若干次插入操作得到
    public static boolean magicString(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        // cm   ccmcmcmm

        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (startIndex <= endIndex) {
            if (s.charAt(startIndex) == 'm') {
                return false;
            }
            if (s.charAt(startIndex + 1) == 'm') {
                startIndex += 2;
            } else {
                if (s.charAt(startIndex) == 'c' && s.charAt(endIndex) == 'm') {
                    startIndex++;
                    endIndex--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
