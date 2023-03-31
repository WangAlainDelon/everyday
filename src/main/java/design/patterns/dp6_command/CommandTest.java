package design.patterns.dp6_command;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandTest {
    /**
     * 命令模式：将请求封装成对象，以便使用不同的请求，队列，或者日志来参数化其他对象，命令模式也支持可撤销的操作
     * 比如我们会向k8s集群发送部署pod以及删除pod的命令
     * 将动作的请求者从动作的执行者对象中解耦
     */

    public static void main(String[] args) {
        List<String> collect = Stream.of("a", "b", "c").collect(Collectors.toList());

        collect.forEach(s -> {
            if (s.equalsIgnoreCase("b")) {
                return;
            }
            System.out.println(s);
        });


    }
}
