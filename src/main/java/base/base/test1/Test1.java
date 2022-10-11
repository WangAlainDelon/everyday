package base.base.test1;

import base.base.pojo.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("w");
        user1.setBirthday(new Date());

        User user2 = new User();
        user2.setName("w");
        user2.setBirthday(new Date());
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        List<User> userList = users.stream().sorted(Comparator.comparing(User::getBirthday)).collect(Collectors.toList());

        AppCenterJarSourceEnum market = AppCenterJarSourceEnum.valueOf("MARKET");

        switch (market) {
            case MARKET:
                System.out.println("1");
                break;
            case HZERO:
                System.out.println("2");
                break;
            default:
                break;
        }


        // == 与equals
//        User user1 = new User();
//        User user2 = new User();
//        user1.setId(1L);
//        user1.setName("a");
//        user2.setId(2L);
//        user2.setName("aa");
//        List<User> users = new ArrayList<>();
//        users = users.stream().filter(user -> user.getId() == null).collect(Collectors.toList());
//
//        System.out.println(user1 == user2);
//        System.out.println(user1.equals(user2));
//        ConcurrentHashMap

    }
}
