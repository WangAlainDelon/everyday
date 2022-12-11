package base.meiju;

public enum AuthorizationTypeE {

    PASSWORD("password"),
    TOKEN("token");

    private final String value;

    AuthorizationTypeE(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }


}
