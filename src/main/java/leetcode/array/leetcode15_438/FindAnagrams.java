package leetcode.array.leetcode15_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        //先将p字符串中字母出现的频率放到一个数组中  同时初始化滑动窗口对应字符串的频率数组
        int[] pArr = new int[256];
        int[] sArr = new int[256];
        char[] chars = p.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            pArr[chars[i]]++;
            sArr[s.charAt(i)]++;
        }
        List<Integer> re = new ArrayList<>();

        //滑动窗口的大小  固定不变，滑动窗口围成的这个数组等于s的时候即是解
        int i = 0;
        int j = chars.length - 1;
        while (j < s.length()) {
            //滑动窗口围成的数组的字母频率相等
            if (Arrays.equals(sArr, pArr)) {
                re.add(i);
            }
            //右移滑动窗口
            j++;
            if (j < s.length()) {
                sArr[s.charAt(j)]++;
            }
            if (sArr[s.charAt(i)] != 0) {
                sArr[s.charAt(i)]--;
            }
            i++;
        }
        return re;
    }
}
