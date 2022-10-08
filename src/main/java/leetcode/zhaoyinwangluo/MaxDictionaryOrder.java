package leetcode.zhaoyinwangluo;

public class MaxDictionaryOrder {

    public static void main(String[] args) {

        maxDictionaryOrder2("aabcbccacbbcbaaba");

    }


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

    public static String maxDictionaryOrder2(String str) {
        int len = str.length();
        StringBuilder ans = new StringBuilder(str.substring(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (str.charAt(i) >= ans.toString().charAt(0))
                ans.insert(0, str.substring(i, i + 1));
        }
        return ans.toString();
    }


}
