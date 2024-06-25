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

    public void insertFirst(T data) {
        DoublyLinkedListNode<T> newDoublyLinkedListNode = new DoublyLinkedListNode<>(data);

        if (this.head == null) {
            this.tail = newDoublyLinkedListNode;
        } else {
            this.head.setPrev(newDoublyLinkedListNode);
            newDoublyLinkedListNode.setNext(this.head);
        }
        this.head = newDoublyLinkedListNode;
        doublyLinkedListLength++;
    }

    public void insertAfter(int index, T data) {
        validateIndex(index);
        insert(index, data);
    }

    public void insertBefore(int index, T data) {
        if (index == 0) {
            insertFirst(data);
        } else {
            validateIndex(index);
            insert(index - 1, data);
        }
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

    public void deleteDoublyLinkedListNode(int index) {
        validateLinkedList();
        validateIndex(index);

        DoublyLinkedListNode<T> temp = this.head;

        if (index == 0) {
            this.head = this.head.getNext();
            if (this.head == null) {
                this.tail = null;
            }  else {
                this.head.setPrev(null);
            }

            this.doublyLinkedListLength--;
        }
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

    private void insert(int index, T data) {
        validateLinkedList();

        DoublyLinkedListNode<T> newDoublyLinkedListNode = new DoublyLinkedListNode<>(data);
        DoublyLinkedListNode<T> temp = this.head;

        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }

        DoublyLinkedListNode<T> tempNext = temp.getNext();
        newDoublyLinkedListNode.setPrev(temp);
        newDoublyLinkedListNode.setNext(tempNext);
        temp.setNext(newDoublyLinkedListNode);
        if (tempNext == null) {
            this.tail = newDoublyLinkedListNode;
        } else {
            tempNext.setPrev(newDoublyLinkedListNode);
        }

        doublyLinkedListLength++;
    }
}
