public class DoubleLinkedList<T> {
    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int doublyLinkedListLength;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.doublyLinkedListLength = 0;
    }

    public void insertLast(T data) {
        DoublyLinkedListNode<T> newDoublyLinkedListNode = new DoublyLinkedListNode<>(data);

        if (this.head == null) {
            this.head = newDoublyLinkedListNode;
        } else {
            this.tail.setNext(newDoublyLinkedListNode);
            newDoublyLinkedListNode.setPrev(this.tail);
        }
        this.tail = newDoublyLinkedListNode;
        doublyLinkedListLength++;
    }

    public void printLinkedList() {
        if (this.head == null) {
            System.out.println("The list is empty.");
            return;
        }

        DoublyLinkedListNode<T> temp = this.head;
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

    public void printLinkedListReverse() {
        if (this.head == null) {
            System.out.println("The list is empty.");
            return;
        }

        DoublyLinkedListNode<T> temp = this.tail;
        StringBuilder result = new StringBuilder();

        while (temp != null) {
            result.append(temp.getData());
            if (temp.getPrev() != null) {
                result.append(", ");
            }
            temp = temp.getPrev();
        }

        System.out.println(result);
    }

    public int getDoublyLinkedListLength() {
        return doublyLinkedListLength;
    }

    private void validateLinkedList() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException("List is empty.");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.doublyLinkedListLength) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
    }
}
