public class LinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
    }

    public void printLinkedList() {
        Node<T> temp = this.head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
