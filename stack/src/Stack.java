public class Stack<T> {
    private final LinkedList<T> linkedList;

    public Stack() {
        linkedList = new LinkedList<>();
    }

    public void push(T data) {
        linkedList.insertFirst(data);
    }

    public T peek() {
        return this.linkedList.getHead().getData();
    }

    public T pop() {
        T data = this.linkedList.getHead().getData();
        this.linkedList.deleteLinkedListNode(0);
        return data;
    }

    public void print() {
        this.linkedList.printLinkedList();
    }

    public int size() {
        return linkedList.getLinkedListLength();
    }

    public boolean isEmpty() {
        return this.linkedList.getHead() == null;
    }
}
