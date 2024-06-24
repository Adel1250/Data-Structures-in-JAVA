public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.insertLast("Adel");
        linkedList.deleteLinkedListNode(0);
        linkedList.insertLast("Ashraf");
        linkedList.insertLast("Mohamed");
        linkedList.insertFirst("Name");
        linkedList.printLinkedList();
        System.out.println(linkedList.getLinkedListLength());
        linkedList.insertAfter(1, "Yeah");
        linkedList.insertBefore(1, "Oh");
        linkedList.printLinkedList();
        System.out.println(linkedList.findNodeIndex("Oh"));
        linkedList.deleteLinkedListNode(1);
        linkedList.printLinkedList();
        linkedList.deleteLinkedListNode(linkedList.getLinkedListLength() - 1);
        linkedList.printLinkedList();
        linkedList.deleteLinkedListNode(0);
        linkedList.printLinkedList();
    }
}