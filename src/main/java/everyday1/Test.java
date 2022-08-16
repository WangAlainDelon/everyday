package everyday1;

public class Test {

    private int count = 0;

    public void recursiveCalls(String a){


        count++;
        System.out.println("stack depth: " + count);
        recursiveCalls(a);
    }

    public void test(){
        try {
            recursiveCalls("a");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        System.gc();
//        new Test().test();
    }

}
