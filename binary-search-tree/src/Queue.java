public class Queue<T> {
    private final LinkedList<T> linkedList;

    public Queue() {
        this.linkedList = new LinkedList<>();
    }

    public void enqueue(T data) {
        this.linkedList.insertLast(data);
    }

    public T dequeue() {
        T data = this.linkedList.getHead().getData();
        this.linkedList.deleteLinkedListNode(0);
        return data;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean isEmpty() {
        return this.linkedList.getHead() == null;
    }
}
