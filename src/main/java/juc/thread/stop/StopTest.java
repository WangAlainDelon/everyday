package juc.thread.stop;

public class StopTest {
    static boolean foo(char c){
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        String lx = "LeXin";
        String nb = lx;
        lx = "Fenqile";
        System.out.println(nb);


    }

    private void test2() {
        System.out.println("1");

    }

//    class Task extends Thread{
//        @Override
//        public void run() {
//           th\
//        }
//    }
}

class Example {
    String str = new String("tarena");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String args[]) {


    }

    public static void change() {
        //引用类型变量，传递的是地址，属于引用传递。
        System.out.println("12");
    }



    static class Person {
        private int age;

        public int getAge() {
            return age;
        }

        public static void setAge(int age) {
            float f[][] = new float[6][];
        }
    }

}



