public class TestController {

    public static void main(String[] args) {
        // Java 写一个链表  做一个链表反转
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.setNextNode(node2);
        node2.setNextNode(node3);

//        reList(node1);
    }

//    private static Node reList(Node node) {
//        Node head = new Node(null);
//        while (node.getNextNode() != null) {
//            Node next = temp.getNextNode();
//            next.setNextNode(node);
//            temp = node.getNextNode();
//        }
//        return temp;
//    }
}
