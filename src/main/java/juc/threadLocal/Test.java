package juc.threadLocal;

import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by wangxiang on 2022/7/27
 */
public class Test {
    private static Logger LOGGER = Logger.getLogger(Test.class);

    static char[] bigNum = new char[26];
    static char[] smallNum = new char[26];
    static int[] num = new int[10];
    private static Random random;

    static {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info("Exception:{}", e);
        }
    }

    public static void init() {
        //生成大写字母表,对照ASIC表
        for (int i = 65; i <= 90; i++) {
            bigNum[i - 65] = (char) i;
        }
        //生成小写字母表
        for (int i = 97; i <= 122; i++) {
            smallNum[i - 97] = (char) i;
        }
        //生成数字表
        for (int i = 0; i <= 9; i++) {
            num[i] = i;
        }
    }

    public static String getPassword() throws InterruptedException {
        int len = 8;
        String str = "";
        init();
        Thread.sleep(5000);

        //需要先随机生成len长度中，大写字母的个数，小写字母的个数以及数字的个数，且保证每个个数都不能为0
        int big_len = random.nextInt(len - 2) + 1;
        int small_len = random.nextInt(len - big_len - 1) + 1;
        int num_len = len - big_len - small_len;
        //每一位生成对应的密码
        for (int i = 0; i < big_len; i++) {
            str += bigNum[random.nextInt(26)];
        }
        for (int i = 0; i < small_len; i++) {
            str += smallNum[random.nextInt(26)];
        }
        for (int i = 0; i < num_len; i++) {
            str += num[random.nextInt(10)];
        }
        return str;
    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
//        for (int i = 0; i < 10; i++) {
//            MyThread myThread = new MyThread();
//            myThread.start();
//        }


//        List<Character> characters = new ArrayList<>();
//        String s = "scscs";
//        char[] toCharArray = s.toCharArray();
//        for (char c : toCharArray) {
//            characters.add(c);
//        }
//
//        ThreadLocal threadLocal = new InheritableThreadLocal<String>();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                threadLocal.set("v");
//                System.out.println("设置值");
//                System.out.println(threadLocal.get());
//            }
//        }).start();
//
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threadLocal.get();


//        threadLocal.remove();

    }

    public static int count(String src, String target) {
        String[] arr = src.split(target);
        // 截取最后一段判断是否相等，因为相等会影响截取
        if (src.substring(src.length() - target.length()).equals(target)) {
            return arr.length;
        } else {
            return arr.length - 1;
        }
    }


}
