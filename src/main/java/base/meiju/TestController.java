package base.meiju;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class TestController {

    public static void main(String[] args) {

        boolean token = Arrays.stream(AuthorizationTypeE.values()).anyMatch(authorizationTypeE -> StringUtils.equalsIgnoreCase(authorizationTypeE.value(), "ccc"));
    }
}
