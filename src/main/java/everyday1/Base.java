package everyday1;

public class Base {
    int w, x, y, z;

    public Base(int a, int b) {
        x = a;
        y = b;
    }

    public Base(int a, int b, int c, int d) {
//        new Base(a, b);
        int x = a, y = b;
        w = d;
        z = c;
    }

    public void test() {
    }

}

class B extends Base {

    public B(int a, int b) {
        super(a, b);
    }

    public B(int a, int b, int c, int d) {
        super(a, b, c, d);
    }

    private void tt() {
        super.test();
    }
}
