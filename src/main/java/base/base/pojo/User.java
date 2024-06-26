package base.base.pojo;

import java.util.Date;

public class User im{
    public User(Long id) {
        this.id = id;
    }

    public User() {
    }

    private Long id;
    private String name;
    private Date birthday;
    private User user;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
