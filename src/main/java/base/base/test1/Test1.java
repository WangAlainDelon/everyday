package base.base.test1;

import base.base.pojo.User;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Test1 {

    public static void main(String[] args) {
        // == 与equals
        User user1 = new User();
        User user2 = new User();
        user1.setId(1L);
        user1.setName("aa");
        user2.setId(1L);
        user2.setName("aa");

        System.out.println(user1 == user2);
        System.out.println(user1.equals(user2));

    }
}
