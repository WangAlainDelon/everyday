package leetcode.array.leetcode8_167;

public class TwoSum {


    public static void main(String[] args) {
        //两数之和
    }

    public static int[] twoSum3(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index1 < index2) {
            if (numbers[index1] + numbers[index2] == target) {
                break;

            } else if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else {
                index2--;
            }
        }
        return new int[]{index1 + 1, index2 + 1};
    }
}
