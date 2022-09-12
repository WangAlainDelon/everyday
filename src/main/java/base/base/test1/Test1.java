package base.base.test1;

import base.base.pojo.User;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
        // == 与equals
        User user1 = new User();
        User user2 = new User();
        user1.setId(1L);
        user1.setName("a");
        user2.setId(2L);
        user2.setName("aa");
        List<User> users = new ArrayList<>();
        users = users.stream().filter(user -> user.getId() == null).collect(Collectors.toList());

        System.out.println(user1 == user2);
        System.out.println(user1.equals(user2));
//        ConcurrentHashMap

    }
}
