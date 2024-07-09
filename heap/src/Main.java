public class Main {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.insert(24);
        heap.insert(32);
        heap.insert(16);
        heap.insert(45);
        heap.insert(20);
        heap.insert(53);
        heap.insert(14);
        heap.insert(27);

        heap.printHeap();
        System.out.println(heap.pop());
        heap.printHeap();
    }
}