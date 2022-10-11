package everyday1;

public class Test {

    private int count;

    public void recursiveCalls(String a) {
        byte i = 12;
//        int j;
//        j = i;
//        boolean i = null;
//        Boolean i = null;
//        long i = 0xffL;



        count++;
        System.out.println("stack depth: " + count);
        recursiveCalls(a);
    }

    public void test() {
        try {
            recursiveCalls("a");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public static void main(String[] args) {
//
//        System.gc();
////        new Test().test();
//    }

    public static void main(String args[]) {
        double j = 0.92392365888888881111111111111111111111111111111111111111111111111111113333333366555d;

        int a = 10;
        int b;
        int c;
        if (a > 50) {
            b = 9;
        }
        Test test = new Test();
        c = test.count + a;
    }

}
