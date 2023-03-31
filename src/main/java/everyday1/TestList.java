package everyday1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {

    public static void main(String[] args) throws JsonProcessingException, URISyntaxException {
        Integer a=10;
        String ab=a+"dasda";


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
}
