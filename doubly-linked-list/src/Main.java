public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.insertLast(1);
        doubleLinkedList.insertLast(2);
        doubleLinkedList.insertLast(3);

        doubleLinkedList.printLinkedList();
        doubleLinkedList.printLinkedListReverse();

        System.out.println("Doubly linked list length: " + doubleLinkedList.getDoublyLinkedListLength());
    }
}