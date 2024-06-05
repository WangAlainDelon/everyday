public class Node {

    private Object value;
    private Node nextNode;

    public Node(Object value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public Node(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
