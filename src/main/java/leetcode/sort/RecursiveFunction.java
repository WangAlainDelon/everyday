package leetcode.sort;

/**
 * Created by wangxiang on 2022/2/21
 */
public class RecursiveFunction {
    public static void main(String[] args) {
        getN(3);
    }


    //计算n的阶乘的递归

    public static void getN(int n) {
        if (n == 0) {
            System.out.println("结束条件终止递归");
            return;
        } else {
            getN(n - 1);
        }
        System.out.println("神奇小子" + n);
    }

}
