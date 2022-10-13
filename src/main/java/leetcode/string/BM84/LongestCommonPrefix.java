package leetcode.string.BM84;

import java.util.HashSet;

public class LongestCommonPrefix {


    public static void main(String[] args) {

        String[] str = {"a", "b"};
        String s = longestCommonPrefix(str);

    }

    /**
     * 给你一个大小为 n 的字符串数组 strs ，其中包含n个字符串 , 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀
     * 暴力解法
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        boolean re = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            Character temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i <= strs[j].length() - 1) {
                    Character c = strs[j].charAt(i);
                    if (temp.equals(c) && temp != null) {

                    } else {
                        re = false;
                        break;
                    }
                } else {
                    re = false;
                    break;
                }
            }
            if (re) {
                sb.append(temp);
            }
        }
        return sb.toString();
    }


    /**
     * 横向扫描
     **/
    public String longestCommonPrefix2(String[] strs) {
        // //纵向扫描
        if (strs.length == 0 || strs == null) {
            return "";
        }

        int rows = strs.length;
        int cols = strs[0].length();
        //开始扫描
        for (int i = 0; i < cols; i++) {
            char firstChar = strs[0].charAt(i);
            for (int j = 1; j < rows; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != firstChar) { /// beautiful
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
