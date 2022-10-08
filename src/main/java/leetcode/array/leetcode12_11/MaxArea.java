package leetcode.array.leetcode12_11;

public class MaxArea {

    public static void main(String[] args) {
        //容器可以容纳多少水
    }

    public int maxArea(int[] height) {
        int max = 0;

        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int high = height[i] > height[j] ? height[j] : height[i];
            int lang = j - i;
            if (high * lang > max) {
                max = high * lang;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

}
