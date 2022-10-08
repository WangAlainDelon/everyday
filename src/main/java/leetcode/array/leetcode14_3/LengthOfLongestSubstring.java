package leetcode.array.leetcode14_3;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[256];
        int i = 0;
        int j = -1;
        int re = 0;
        //双指针形成的滑动窗口开始右移
        while (j < chars.length && i < chars.length) {
            //滑动窗口的左边往右移动的条件，是左边元素的下一个元素的出现频率为0
            if (j + 1 < chars.length && freq[chars[j + 1]] == 0) {
                freq[chars[j + 1]]++;
                j++;
            } else {
                //当滑动窗口右边不滑动左边开始往右滑动的时候
                freq[chars[i]]--;
                i++;
            }
            re = Math.max((j - i + 1), re);
        }
        return re;
    }
}
