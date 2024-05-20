package everyday1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class TestList {


    public static void main(String[] args) throws JsonProcessingException, URISyntaxException, UnsupportedEncodingException {

        String test="https%3A%2F%2Fminioapi-devops.haday.cn%2Fprivate%2Fagile-service%2F3%2FCHOERODON-MINIO%2F9d113b7f1be7464f95990b62d2f50fbb%2F%E6%B5%8B%E8%AF%95%E9%A1%B9%E7%9B%AE0123%20(1).xlsx";
        String s4 = URLDecoderUtils.decodeIfNeeded(test);

        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "b");
        String s3 = JSONObject.toJSONString(map1);

        List<String> stringList2 = Arrays.asList("a", "b");
        List<String> stringList3 = Arrays.asList("c", "d");
        List<String> collect = Arrays.asList(stringList2, stringList3).stream().flatMap(Collection::stream).collect(Collectors.toList());

        String g = "c";
        String[] split = g.split(",");
        for (String s : split) {
            List<String> stringList1 = Arrays.asList("a", "b");
            boolean contains = stringList1.contains(s);
        }


        String[] array = new String[]{"a", "b"};
        String[] newStatus = Arrays.copyOf(array, array.length + 1);
        newStatus[newStatus.length - 1] = "c";
        array = newStatus;

        /**
         * {
         * 	"elements": [{
         * 				"tag": "column_set",
         * 				"flex_mode": "none",
         * 				"background_style": "grey",
         * 				"columns": [
         *
         *                                        {
         * 						"tag": "column_set",
         * 						"flex_mode": "none",
         * 						"background_style": "grey",
         * 						"columns": [{
         * 								"tag": "column",
         * 								"width": "weighted",
         * 								"weight": 4,
         * 								"vertical_align": "top",
         * 								"elements": [{
         * 										"tag": "markdown",
         * 										"content": "[这里是概要这里是概要这里是概要这里是概要](https://www.feishu.cn)"
         *                                    },
         *                                    {
         * 										"tag": "note",
         * 										"elements": [{
         * 												"tag": "img",
         * 												"img_key": "img_v2_041b28e3-5680-48c2-9af2-497ace79333g",
         * 												"alt": {
         * 													"tag": "plain_text",
         * 													"content": ""
         *                                                }
         *                                            },
         *                                            {
         * 												"tag": "plain_text",
         * 												"content": "预计结束：2023-12-12"
         *                                            }
         * 										]
         *                                    }
         * 								]
         *                            },
         *                            {
         * 								"tag": "column",
         * 								"width": "weighted",
         * 								"weight": 1,
         * 								"vertical_align": "top",
         * 								"elements": [{
         * 									"tag": "markdown",
         * 									"content": "小王"
         *                                }]
         *                            }
         * 						]
         *                    }
         * 				],
         * 				"header": {
         * 					"template": "blue",
         * 					"title": {
         * 						"content": "您在「这里是项目名称」项目有123个工作项预计10天后开始处理",
         * 						"tag": "plain_text"
         *                    }* 				}
         *            }
         */

        /**
         * +     %2B
         * /      %2F
         * ?     %3F
         * %    %25
         * #     %23
         * &    %26
         */
        StringBuilder sb = new StringBuilder();
        sb.append("{" +
                "\"elements\": [");
        for (int i = 1; i < 3; i++) {
            sb.append("{" +
                    "\"tag\": \"column_set\"," +
                    "\"flex_mode\": \"none\"," +
                    "\"background_style\": \"grey\"," +
                    "\"columns\": [{" +
                    "\"tag\": \"column\"," +
                    "\"width\": \"weighted\"," +
                    "\"weight\": 4," +
                    "\"vertical_align\": \"top\"," +
                    "\"elements\": [{" +
                    "\"tag\": \"markdown\"," +
                    "\"content\": \"");
            sb.append("issue的名字")
                    .append("\"" +
                            "}," +
                            "{" +
                            "\"tag\": \"note\"," +
                            "\"elements\": [{" +
                            "\"tag\": \"img\"," +
                            "\"img_key\": \"img_v2_041b28e3-5680-48c2-9af2-497ace79333g\"," +
                            "\"alt\": {" +
                            "\"tag\": \"plain_text\"," +
                            "\"content\": \"\"" +
                            "}" +
                            "}," +
                            "{" +
                            "\"tag\": \"plain_text\"," +
                            "\"content\": \"预计结束：")
                    .append(2025)
                    .append("\"" +
                            "}" +
                            "]" +
                            "}" +
                            "]" +
                            "}," +
                            "{" +
                            "\"tag\": \"column\"," +
                            "\"width\": \"weighted\"," +
                            "\"weight\": 1," +
                            "\"vertical_align\": \"top\"," +
                            "\"elements\": [{" +
                            "\"tag\": \"markdown\"," +
                            "\"content\": \"")
                    .append("wx")
                    .append("\"" +
                            "}]" +
                            "}" +
                            "]" +
                            "}");

            if (i != 2) {
                sb.append(",");
            }
        }
        sb.append("]," +
                        "\"header\": {" +
                        "\"template\": \"blue\"," +
                        "\"title\": {" +
                        "\"content\": \"")
                .append("这是一个题目")
                .append("\"," +
                        "\"tag\": \"plain_text\"" +
                        "}" +
                        "}" +
                        "}");

        String s2 = sb.toString();


        Map<String, String> map = new HashMap<>();
        map.put("%2B", "+");
        map.put("%2F", "/");
        String s1 = JSON.toJSONString(map);

        Long A = 505707671924731904L;

        Long B = 505707671924731904L;
        boolean equals = A.equals(B);

        String url = "21+#&?@需求说明书_ERP-PM_项目绩效考核_BS021_V1.4.5-20230307.docx";

        boolean contains = url.contains("+");

        String url2 = "21%2B需求说明书_ERP-PM_项目绩效考核_BS021_V1.4.5-20230307.docx";
        URLDecoder.decode(url, "utf-8");
        String decode = URLDecoder.decode(URLEncoder.encode(url, "UTF-8"), "UTF-8");

        String decode2 = URLDecoder.decode(URLEncoder.encode(url2, "UTF-8"), "UTF-8");

//        User cc = new User();
//        cc.setIsError(true);
//        testwx(cc);


        List<String> list = Arrays.asList("1", "2", "3", "5", "5");

        for (String s : list) {
            if (s.equals("2")) {
                continue;
            }
            System.out.println(s);
        }

        String join = String.join(",", list);

        Integer a = 10;
        String ab = a + "dasda";


        String path = TestList.class.getClassLoader().getResource("").toURI().getPath().replaceAll(".*webapps/|/(?i)web-inf/classes/|/build/classes/", "");


        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("fuck");
        String resBody = "{\"isError\":true,\"message\":\"用户名或密码错误！\",\"obj\":{\"detailMessage\":\"用户名或密码错误！\",\"stackTrace\":[],\"suppressedExceptions\":[]}}";
        User user = objectMapper.readValue(resBody, User.class);


        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("i");
        stringList.add("j");
        stringList.add("a");


        //无重并集
        List<String> stringList2_2 = new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h".split(",")));
        List<String> stringList_1 = new ArrayList<>(Arrays.asList("a,b,c,i,j,a".split(",")));
        stringList2_2.removeAll(stringList_1);
        stringList_1.addAll(stringList2_2);

    }

    private static void testwx(Object user) {
        Object isError = getFieldValueByName(user, "isError");
    }

    public static Object getFieldValueByName(Object o, String fieldName) {

        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
