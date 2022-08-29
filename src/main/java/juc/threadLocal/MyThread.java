package juc.threadLocal;

/**
 * Created by wangxiang on 2022/8/2
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        try {
            //在线程栈中填入1M
            Byte[] bytes = new Byte[110001];
            Tools.threadLocal.set(bytes);
            System.out.println("设置成功");

//            Thread.sleep(3000);
//            String password = HarborUtil.getPassword();
//            System.out.println("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
