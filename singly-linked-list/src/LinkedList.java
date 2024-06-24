import java.util.Objects;

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

    public void insertFirst(T data) {
        LinkedListNode<T> newLinkedListNode = new LinkedListNode<>(data);
        if (this.head == null) {
            this.tail = newLinkedListNode;
        } else {
            newLinkedListNode.setNext(this.head);
        }
        this.head = newLinkedListNode;
        linkedListLength++;
    }

    public void insertAfter(int index, T data) {
        validateLinkedList();
        insert(index, data);
    }

    public void insertBefore(int index, T data) {
        validateLinkedList();
        insert(index - 1, data);
    }

    public int findNodeIndex(T data) {
        if (this.head == null) {
            return -1;
        }
        LinkedListNode<T> temp = this.head;
        int index = 0;
        while (temp != null) {
            if (Objects.equals(temp.getData(), data)) {
                return index;
            }
            temp = temp.getNext();
            index++;
        }
        return -1;
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

    public int getLinkedListLength() {
        return linkedListLength;
    }

    public void deleteLinkedListNode(int index) {
        validateLinkedList();
        validateIndex(index);

        LinkedListNode<T> temp = this.head;
        if (index == 0 && this.linkedListLength == 1) {
            this.head = null;
            this.tail = null;
        } else if (index == 0 && this.linkedListLength > 1) {
            this.head = this.head.getNext();
        } else if (index == this.linkedListLength - 1 && this.linkedListLength > 1) {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            this.tail = temp;
            this.tail.setNext(null);
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        this.linkedListLength--;
    }

    private void insert(int index, T data) {
        validateIndex(index);
        LinkedListNode<T> newLinkedListNode = new LinkedListNode<>(data);
        LinkedListNode<T> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        newLinkedListNode.setNext(temp.getNext());
        temp.setNext(newLinkedListNode);
        linkedListLength++;
    }

    private void validateLinkedList() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException("List is empty.");
        }
    }

    private void validateIndex(int index) {
        if (index >= this.linkedListLength) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
    }
}
