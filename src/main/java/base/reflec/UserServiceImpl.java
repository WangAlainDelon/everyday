package base.reflec;

public class UserServiceImpl {


    @WXSaga
    public void createUser(Long userId) {

        System.out.println("创建用户成功:" + userId);
    }

}
