package design.patterns.dp6_command;

public class K8sCommand implements Command {
    private K8sClient k8sClient;

    public K8sCommand(K8sClient k8sClient) {
        this.k8sClient = k8sClient;
    }

    @Override
    public void execute() {
        k8sClient.deployInstance();
    }

    @Override
    public void undo() {
        k8sClient.deleteInstance();
    }
}
