package leetcode.string.BM83;

public class Trans {
    /**
     * 以空格隔开反转字符串，大小也一起反转
     */
    public static void main(String[] args) {
        String this_is_a_sample = trans("This is a sample", 16);
    }

    //
    public static String trans(String s, int n) {

        if (s == null || s.equals("")) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        for (String subString : split) {
            String s1 = reverseString(subString);
            sb.insert(0, s1);
            sb.insert(0, " ");
        }
        return sb.toString().trim();
    }

    private static String reverseString(String subString) {
        char[] toCharArray = subString.toCharArray();
        for (int i = 0; i < toCharArray.length / 2; i++) {
            char c = toCharArray[i];
            toCharArray[i] = toCharArray[subString.length() - 1 - i];
            toCharArray[subString.length() - 1 - i] = c;
        }
        for (int i = 0; i < subString.length(); i++) {
            if (Character.isUpperCase(toCharArray[i])) {
                toCharArray[i] = Character.toLowerCase(toCharArray[i]);
            } else {
                toCharArray[i] = Character.toUpperCase(toCharArray[i]);
            }
        }
        return new String(toCharArray);
    }


    /**
     *  题解： 以空格为界，将单词压入栈  然后弹出栈即可
     */
}
