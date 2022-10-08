package test;

public class Test {


    public static void main(String[] args) {
        String s = "aabcbccacbbcbaaba";


        StringBuilder sb = new StringBuilder();
        String s1 = maxDictionaryOrder(s, sb);
    }


    //一个字符串是否能由cm通过若干次插入操作得到
    public static boolean magicString(String s) {
        if (s == null || s.equals("")) {
            return true;
        }

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

    //求出给定字符串的子序列，按照字典顺序最大的是哪一个？
    public static String maxDictionaryOrder(String s) {
        StringBuilder sb = new StringBuilder();
        //用递归的方法每次从剩余的字串中找到最大的字符
        if (s == null || s.equals("")) {
            return "";
        }
        char max = s.charAt(0);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > max) {
                max = s.charAt(i);
            }
        }
        int maxIndex = s.indexOf(max);
        int endMaxIndex = s.lastIndexOf(max);
        //从剩余的字串中找到最大的字母
        String s1 = maxDictionaryOrder(s.substring(endMaxIndex + 1));
        for (int i = maxIndex; i <= s.length() - 1; i++) {
            if (s.charAt(i) == max) {
                sb.append(max);
            }
        }
        return sb.toString();
    }
}
