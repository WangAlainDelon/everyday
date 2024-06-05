package base.base.test1;

import base.base.pojo.User;
import com.sun.xml.internal.ws.util.CompletedFuture;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test1 {


    public static void main(String[] args) throws ParseException {

        User user=new User();
        user.setId(null);
        Long id = getId(user);

        BigDecimal


        String s1 = Boolean.TRUE.toString();
        byte[] bytes = new byte[1048576];
        BitSet bitSet = new BitSet(122);
        bitSet.set(811111111);

        Boolean a = true;
        String s = a.toString();

        Map<String, String> stringMap = new HashMap<>();
        String put1 = stringMap.put("1", "6");
        String put = stringMap.put("1", "7");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Object o = new Object();

        String formatTime = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29) (20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9]$";
        String formatTime2 = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29) (20|21|22|23|[0-1][0-9]):[0-5][0-9]$";


        String date = "2022-10-25 14:40";
        String date1 = "2022-10-25 14:40:45";

        Pattern compile = Pattern.compile(formatTime);
        boolean matches = compile.matcher(date).matches();
        boolean matches1 = compile.matcher(date1).matches();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parse = sdf.parse(date);

//        Date parse = sdf.parse(date);
        Object time = parse.getTime();
//        Date parse1 = sdf.parse(time);

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

    private static Long getId(User user) {
        return user != null ? 0L : Optional.ofNullable(user.getId()).orElse(0L);
    }
}
