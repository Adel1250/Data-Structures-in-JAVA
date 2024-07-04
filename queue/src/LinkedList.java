public class LinkedList<T> {
    private LinkedListNode<T> head = null;
    private LinkedListNode<T> tail = null;
    private int linkedListLength = 0;

    public void insertLast(T data) {
        LinkedListNode<T> newLinkedListNode = new LinkedListNode<>(data);
        if (this.head == null) {
            this.head = newLinkedListNode;
        } else {
            this.tail.setNext(newLinkedListNode);
        }
        this.tail = newLinkedListNode;
        linkedListLength++;
    }

    public void printLinkedList() {
        if (this.head == null) {
            System.out.println("The list is empty.");
            return;
        }

        LinkedListNode<T> temp = this.head;
        StringBuilder result = new StringBuilder();

        while (temp != null) {
            result.append(temp.getData());
            if (temp.getNext() != null) {
                result.append(", ");
            }
            temp = temp.getNext();
        }

        System.out.println(result);
    }

    public void deleteLinkedListNode(int index) {
        validateLinkedList();
        validateIndex(index);

        LinkedListNode<T> temp = this.head;

        if (index == 0) {
            this.head = this.head.getNext();
            if (this.head == null) { // List became empty
                this.tail = null;
            }
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }

            if (temp.getNext() == this.tail) {
                this.tail = temp;
            }

            temp.setNext(temp.getNext().getNext());
        }

        this.linkedListLength--;
    }

    private void validateLinkedList() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException("List is empty.");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.linkedListLength) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
    }

    public LinkedListNode<T> getHead() {
        return head;
    }
}
