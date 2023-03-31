package design.patterns.dp6_command;

public class K8sClient implements Client {


    @Override
    public void deployInstance() {
        System.out.println("部署K8s实例");
    }

    @Override
    public void deleteInstance() {
        System.out.println("删除K8s实例");
    }
}
