package leetcode.array.leetcode9_125;

public class IsPalindrome {


    public static void main(String[] args) {
        //验证回文串
    }

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();
        char[] chars = s.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetterOrDigit(chars[i])) {
                stringBuilder.append(Character.toLowerCase(chars[i]));
            }
        }
        s = stringBuilder.toString();
        chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;

    }
}
