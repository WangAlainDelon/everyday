package base.list;

import static jdk.nashorn.internal.objects.NativeArray.filter;

import base.base.pojo.User;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 项目字段
 *
 * @author 汪翔 2023-04-13
 * @since 2.4
 */
public class TestController {
    private static boolean iscon(String str){


        URL url;
        try {
            //url = new URL("http://www.baidu.com");
            url = new URL(str);
            InputStream in = url.openStream();
            System.out.println("连接正常");
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
        return true;

    }

    public static void main(String[] args) throws MalformedURLException {
        String ps="<p> asdasda</p>";
        int i = ps.lastIndexOf("</p>");
        String testv = ps.substring(0, i);
        String s2 = testv + "dasda" + "</p>";

        String des="[{\"insert\":\"累积流\\n图更改时间范围不发请求，后台事件范围是写死返回的，前端更改时间过滤\\n\"},{\"insert\":{\"image\":\"https://zkc7n-agile-service.obs.cn-east-3.myhuaweicloud.com/file_596b6631289249ddbb314411d3f7107b_blob.png\"}},{\"insert\":\"\\n\"}]";

        JSONArray jsonArray = JSONArray.parseArray(des);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("insert", "汪先生最帅");
        jsonArray.add(jsonObject);
        String s3 = jsonArray.toJSONString();

        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        List<String> stringList1 = filterTest(stringList, "c", false);
        stringList = filterTest(stringList, "c", true);


        List<String> temp1 = new ArrayList<>();
        for (String s : stringList) {
            temp1.add(s);
        }
        temp1.remove("a");


        LocalDate now = LocalDate.now();
        String s1 = now.toString();
        Object date = new Date();

        Date msg1 = (Date) date;

        List<User> list = new ArrayList<>();
        Map<Long, List<User>> collect2 = list.stream().collect(Collectors.groupingBy(User::getId));


        List<Long> collect1 = list.stream().map(User::getId).collect(Collectors.toList());
        User user1 = new User();
        user1.setId(10L);
        user1.setName("张三");

        User user2 = new User();
        user2.setId(20L);
        user2.setName("张四");

        User user3 = new User();
        user3.setId(30L);
        user3.setName("张五");

        user1.setUser(user2);
        user2.setUser(user3);

        List<User> userList1 = new ArrayList<>();
        userList1.add(user1);

        User user22 = new User();
        user22.setId(20L);
        user22.setName("张四");


        List<User> userList2 = new ArrayList<>();
        userList2.add(user22);


        User user4 = userList2.get(0);

        List<User> collect3 = userList1.stream().filter(user -> user.getId().equals(user4.getId())).collect(Collectors.toList());


        if (userList1.containsAll(userList2)) {

        }




        List<User> userList3 = new ArrayList<>();
        userList3.add(user3);
        List<User> temp=new ArrayList<>();
        temp.add(user1);
        temp.add(user2);
        temp.add(user3);


        List<User> re=new ArrayList<>();
        for (User user : temp) {

            for (User reT : re) {
                if (re.contains(user)) {
                    continue;
                }
                re.add(user);
            }
        }





        list.sort(Comparator.comparing(User::getId));
        for (User user : list) {
            if (user.getId() == 20) {
                continue;
            }
            System.out.println(user.getName());
        }



        Map<Long, Long> longLongMap = null;
        longLongMap = new HashMap<>();
        longLongMap.put(null, null);
        Long aLong = Optional.ofNullable(longLongMap).orElseGet(() -> new HashMap<>()).keySet().stream().filter(aLong1 -> aLong1!=null ).findFirst().orElseGet(() -> 0L);


        boolean iscon = iscon("https://register.dev.yqcloud.com/");


        String test = "/test-service/test/1128/CHOERODON-MINIO/6c59fd1be8fc46ebadefa950a61669fd@2.5.0alpha全量测试.xlsx";
        String substring = test.substring(15);

        Long aa=new Long(451682428575023104L);
        Long bb=new Long(451682428575023104L);
        if (Objects.equals(aa,bb)) {
            System.out.println("相等");
        }



        String s = UUID.randomUUID().toString();
        String sss = "project";
        Set<String> collect = Stream.of(sss.trim().split("\\s*,\\s*"))
                .collect(Collectors.toSet());

        Pattern p = Pattern.compile("");
        Matcher m = p.matcher(sss);
        boolean b = m.find();


        URL url = new URL("https://zkc7n-agile-service.obs.cn-east-3.myhuaweicloud.com:443/1120/CHOERODON-HUAWEI/0adfd559bc9f487b99537e44dcaf9621@image.png");

        String fileId = getFileId("file_b70422cb3b084d5aaba946ff50314a52_PDF-report-m4.pdf");

        String randomPassword = getRandomPassword(8);




        removeList(list);
        list.forEach(user -> System.out.println(user.getId()));


    }

    private static List<String> filterTest(List<String> stringList, String c, boolean b) {
        List<String> statusFieldValueSettingDTOS = stringList.stream()
                .filter(value -> {
                    if (b) {
                        return !StringUtils.equalsIgnoreCase(value, c);
                    } else {
                        return StringUtils.equalsIgnoreCase(value, c);
                    }
                })
                .collect(Collectors.toList());
        return statusFieldValueSettingDTOS;
    }

    public static String getRandomPassword(int len) {
        String result = makeRandomPassword(len);
        if (result.matches(".*[a-z]{1,}.*\\d{1,}.*")) {
            return result;
        }
        return makeRandomPassword(len);
    }

    //产生8位随机数
    public static String makeRandomPassword(int len) {
        char charr[] = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();

    }

    private static List<User> removeList(List<User> list) {
        User user3 = new User();
        user3.setId(40L);
        user3.setName("张六");
        list.add(user3);
        for (User user : list) {
            if (user.getId() == 10L) {
                continue;
            }
            System.out.println(user.getId());

        }


//        list = list.stream().filter(user -> user.getId() == 10L).collect(Collectors.toList());

//        list = Arrays.asList(user3);

        return list;
    }

    public static String getFileId(String fileKey) {
        int indexOf = fileKey.indexOf("_");
        if (indexOf > -1) {
            String[] s = fileKey.split("_");
            return s[1];
        } else {
            return "";
        }
    }
}