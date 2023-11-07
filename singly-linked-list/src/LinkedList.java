public class LinkedList {
    private Node head = null;
    private Node tail = null;
    private int length = 0;

    public void insert(int data) {
        Node newNode = new Node();
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        newNode.setData(data);
        this.tail.setNext(newNode);
        this.tail = newNode;
        this.length++;
    }

    public void printLinkedList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
