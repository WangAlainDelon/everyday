package base.str;

public class StringTest {
    public static void main(String[] args) {
        Integer x = 128;
        Integer y = 129;
        Integer z = 130;

        Integer integer = new Integer(130);
        Integer integer2 = integer;
        integer2++;
        integer++;

        System.out.println(integer == integer2);

        String ei = new String("ei");
        String ei2 = ei;
        ei2 += "cucuy";
        ei += "cucuy";
        System.out.println(ei == ei2);  // false
        String intern = ei2.intern();
        System.out.println(ei == intern); //false
        String intern1 = ei.intern();
        System.out.println(intern1 == intern); //true
        String e3 = "ei";
        String e4 = e3 + "cucuy";
        String e5 = "ei" + "cucuy";
        System.out.println(e4 == ei); //false
        System.out.println(e4 == intern); //false
        System.out.println(e5 == intern1); //true

    }
}
