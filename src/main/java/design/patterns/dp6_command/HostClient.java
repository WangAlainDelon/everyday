package design.patterns.dp6_command;

public class HostClient implements Client{
    @Override
    public void deployInstance() {
        System.out.println("部署主机实例");
    }

    @Override
    public void deleteInstance() {
        System.out.println("删除主机板实例");
    }
}
