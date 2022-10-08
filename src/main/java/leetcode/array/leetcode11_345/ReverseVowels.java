package leetcode.array.leetcode11_345;

public class ReverseVowels {

    //反转字符串中的元音字母
    public static void main(String[] args) {

    }


    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (i < j && !isVowel(chars[i])) {
                i++;
            }

            while (i < j && !isVowel(chars[j])) {
                j--;
            }
            //交换元音字母
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;

        }
        return String.valueOf(chars);

    }

    private static boolean isVowel(char aChar) {
        return aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u' ||
                aChar == 'A' || aChar == 'E' || aChar == 'I' || aChar == 'O' || aChar == 'U' ? true : false;
    }
}
