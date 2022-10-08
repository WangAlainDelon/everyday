package leetcode.array.leetcode10_344;

public class ReverseString {
    public static void main(String[] args) {
        //反转字符串
    }

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
}
