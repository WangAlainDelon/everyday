package test;

public interface C extends A, B {
    default void test() {
        System.out.println("A,B,V");
    }
}
