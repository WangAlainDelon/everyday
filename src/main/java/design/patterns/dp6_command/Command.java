package design.patterns.dp6_command;

/**
 * 命令模式的命令接口
 */
public interface Command {
    // 命令执行方法
    void execute();

    //命令撤销方法
    void undo();
}
